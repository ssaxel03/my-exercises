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
    private Socket clientSocket;
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

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;

        try {
            this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        server.sendMessage(this, this.getName() + " joined the server", false);
        this.sendMessage(this.getTextColor() + this.getName() + " joined the server");

    }

    @Override
    public synchronized void run() {

        if(originalName) {
            this.setName();
        }

        while (true) {
            try {
                String input = in.readLine();
                if (input == null) {
                    this.quit();
                    server.sendMessage(this, this.getTextColor() + this.name + " left the server", false);
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

    public synchronized void setName() {

        String oldName = this.name;

        out.println(TextColor.ANSI_RESET.getColor() + "Type your name below:" + this.getTextColor());

        try {
            boolean nameFlag = true;
            String name;
            while (nameFlag) {
                name = in.readLine();
                if (name.contains(" ") || name.length() > 10 || name.isEmpty()) {
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
        } else {
            server.sendMessage(this, this.getName() + " joined the server", false);
            this.sendMessage(this.getTextColor() + this.getName() + " joined the server");
        }

        this.originalName = false;

    }

    public void setColor() {

        String oldColor = this.textColor.getName();
        TextColor oldTextColor = this.textColor;

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

        server.sendMessage(this, this.name + " changed his color from " + oldTextColor.getColor() + oldColor + TextColor.ANSI_RESET.getColor() + " to " + this.getTextColor() + this.textColor.getName() + TextColor.ANSI_RESET.getColor(), false);
        this.sendMessage(TextColor.ANSI_RESET.getColor() + this.name + " changed his color from " + oldTextColor.getColor() + oldColor + TextColor.ANSI_RESET.getColor() + " to " + this.getTextColor() + this.textColor.getName());

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

        String address = this.getAddress().startsWith("0") ? "host" : this.getAddress();

        return String.format("%1$10s %2$15s %3$s",
                this.name,
                address,
                !this.clientSocket.isClosed() ? TextColor.ANSI_GREEN.getColor() + "ONLINE" + TextColor.ANSI_RESET.getColor() : TextColor.ANSI_RED.getColor() + "OFFLINE" + TextColor.ANSI_RESET.getColor());
    }

    public String getTextColor() {
        return textColor.getColor();
    }

    public String getAddress() {
        return (((InetSocketAddress) this.clientSocket.getRemoteSocketAddress()).getAddress()).toString().replace("/", "");
    }

    public boolean isOnline() {
        return !this.clientSocket.isClosed();
    }


}
