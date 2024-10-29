package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client implements Runnable {

    private final String colorOptions = "Color options:\n- reset\n- red\n- green\n- yellow\n- blue";

    private boolean originalName;
    private String name;
    private TextColor textColor;
    private final Socket clientSocket;
    private final Server server;

    PrintWriter out;
    BufferedReader in;

    public Client(Socket clientSocket, Server server) {

        this.clientSocket = clientSocket;

        try {
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.textColor = TextColor.ANSI_RESET;
        this.server = server;
        this.originalName = true;

    }

    @Override
    public void run() {


        this.setName();

        server.sendMessage(this, this.getTextColor() + this.getName() + " joined the server", false);
        this.sendMessage(this.getTextColor() + this.getName() + " joined the server");

        while (true) {
            try {
                String input = in.readLine();
                if (input == null) {
                    this.quit();
                    server.sendMessage(this, this.name + " left the server", false);
                    return;
                }
                server.sendMessage(this, input, true);
            } catch (IOException ignored) {
            }


        }

    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void setName() {

        String oldName = this.name;

        out.println(TextColor.ANSI_RESET.getColor() + "Type your name below:" + this.getTextColor());

        try {
            boolean nameFlag = true;
            String name;
            while (nameFlag) {
                name = in.readLine();
                if (name.contains(" ") || name.length() > 10) {
                    this.sendMessage(TextColor.ANSI_RESET.getColor() + "Name not valid.\nThe name must have a maximum of 10 character and must not have spaces.\nType your name below:" + this.getTextColor());
                    continue;
                }
                this.name = name;
                nameFlag = false;
            }

        } catch (IOException ignored) {
        }

        if (!originalName) {
            server.sendMessage(this, oldName + " changed his name to " + this.getName(), false);
            this.sendMessage(oldName + " changed his name to " + this.getName());
        }

        this.originalName = false;

    }

    public void setColor() {

        String oldColor = this.textColor.getName();

        out.println(colorOptions);

        out.println(TextColor.ANSI_RESET.getColor() + "Type your color below:" + this.getTextColor());

        try {
            String color;

            outerloop:
            while (true) {
                color = in.readLine();

                for(TextColor textColor : TextColor.values()) {
                    if(textColor.getName().equals(color)) {
                        this.textColor = textColor;
                        break outerloop;
                    }
                }

                this.sendMessage(TextColor.ANSI_RESET.getColor() + "Color not valid.\nThe color must be chosen from the list above.\nType your color below:" + this.getTextColor());
            }

        } catch (IOException ignored) {
        }

        server.sendMessage(this, this.getTextColor() + this.name + " changed his color from " + oldColor + " to " + this.textColor.getName(), false);
        this.sendMessage(this.getTextColor() + this.name + " changed his color from " + oldColor + " to " + this.textColor.getName());

    }

    public void quit() {
        try {
            this.clientSocket.close();
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDetails() {
        return String.format("%1$10s %2$15s %3$7S",
                this.name,
                (((InetSocketAddress) this.clientSocket.getRemoteSocketAddress()).getAddress()).toString().replace("/", ""),
                !this.clientSocket.isClosed() ? "ONLINE" : "OFFLINE");
    }

    public String getTextColor() {
        return textColor.getColor();
    }


}
