package io.codeforall.fanstatics;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final String help = """
            /wh [target user name] [message] - Whisper private messages to other users
            /ls - Lists all users connected to the server
                -d - Shows detailed info about every user's connection
            /cn - Lets the user change its own username
            /cc - Lets the user change its own color
            /q - Leaves the server
            /help - Shows the list of server commands
            """;

    private ServerSocket serverSocket;
    private ArrayList<Client> clients;
    private final ExecutorService cachedPool;

    public Server(int portNumber) {
        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {}

        clients = new ArrayList<>();

        this.cachedPool = Executors.newCachedThreadPool();

    }

    public void run() {

        serverloop:
        while(true) {

            try {

                Socket newSocket = serverSocket.accept();

                String newSocketAddress = (((InetSocketAddress) newSocket.getRemoteSocketAddress()).getAddress()).toString().replace("/", "");

                for (Client client : clients) {
                    if(client.getAddress().equals(newSocketAddress)) {
                        if(client.isOnline()) {
                            PrintWriter out = new PrintWriter(newSocket.getOutputStream(), true);
                            out.println("Only 1 connection per computer allowed");
                            out.close();
                            newSocket.close();
                            continue serverloop;
                        }
                        client.setClientSocket(newSocket);
                        cachedPool.submit(client);
                        continue serverloop;
                    }
                }

                clients.add(new Client(newSocket, this));

                cachedPool.submit(clients.get(clients.size() - 1));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void sendMessage(Client sender, String input, boolean regular) {

        String[] inputSplit = input.split(" ");

        switch(inputSplit[0]) {
            case "/wh":
                whisper(sender, inputSplit);
                break;
            case "/ls":
                list(sender, inputSplit);
                break;
            case "/cn":
                if (inputSplit.length == 1) {
                    sender.setName();
                } else {
                    sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());
                }
                break;
            case "/cc":
                if(inputSplit.length == 1) {
                    sender.setColor();
                } else {
                    sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());
                }
                break;
            case "/q":
                if (inputSplit.length == 1) {
                    sender.quit();
                    this.sendMessage(sender, TextColor.ANSI_RESET.getColor() + sender.getName() + " left the server" + sender.getTextColor(), false);
                } else {
                    sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());
                }
                break;
            case "/help":
                sender.sendMessage(inputSplit.length == 1 ? help : TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());
                break;
            default:
                if (inputSplit[0].startsWith("/")) {
                    sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Unknown command" + sender.getTextColor());
                } else {
                    broadcast(sender, input, regular);
                }
        }

    }

    public void whisper(Client sender, String[] inputSplit) {

        StringJoiner message = new StringJoiner(" ");

        if(inputSplit.length == 1) {
            sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());
            return;
        }

        for(int i = 2; i < inputSplit.length; i++) {
            message.add(inputSplit[i]);
        }

        String toBeDelivered = sender.getName() + ": " + message;

        for(Client client : clients) {
            if(client.getName().equals(inputSplit[1])) {
                client.sendMessage(sender.getTextColor() + toBeDelivered + client.getTextColor());
                return;
            }
        }

        sender.sendMessage(TextColor.ANSI_RESET.getColor() + "User not found" + sender.getTextColor());

    }

    public void list(Client sender, String[] inputSplit) {

        StringBuilder toBeDelivered = new StringBuilder();

        StringJoiner online = new StringJoiner("\n");
        StringJoiner offline = new StringJoiner("\n", "\n", "");

        if(inputSplit.length == 2) {
            if(inputSplit[1].equals("-d")) {
                for(Client client : clients) {
                    toBeDelivered.append(client.getDetails());
                    if (client.isOnline()) {
                        online.add(client.getDetails());
                    } else {
                        offline.add(client.getDetails());
                    }
                }

                String title = String.format("%1$10s %2$15s %3$s\n", "Username", "IP Address", "Status");

                String offlineOut = offline.length() < 3 ? "" : String.valueOf(offline);

                String message = TextColor.ANSI_RESET.getColor() + title + online + offlineOut + sender.getTextColor();

                sender.sendMessage(message);
                return;
            }

            sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Unknown flag" + sender.getTextColor());
            return;

        }

        if(inputSplit.length == 1) {

            for(Client client : clients) {
                toBeDelivered.append(String.format("%1$10s", client.getName())).append("\n");
            }
            sender.sendMessage(TextColor.ANSI_RESET.getColor() + toBeDelivered + sender.getTextColor());
            return;

        }

        sender.sendMessage(TextColor.ANSI_RESET.getColor() + "Invalid arguments" + sender.getTextColor());

    }

    public void broadcast(Client sender, String message, boolean regular) {

        String toBeDelivered;

        if(!regular) {
            toBeDelivered = message;
        } else {
            toBeDelivered = sender.getName() + ": " + message;
        }

        System.out.println((regular ? sender.getTextColor() : TextColor.ANSI_RESET.getColor()) + toBeDelivered + TextColor.ANSI_RESET.getColor());

        for (Client client : clients) {
            if(client.equals(sender)) {
                continue;
            }

            client.sendMessage( (regular ? sender.getTextColor() : TextColor.ANSI_RESET.getColor()) + toBeDelivered + client.getTextColor());
        }

    }
}
