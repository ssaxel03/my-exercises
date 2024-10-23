package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 8080);

        Scanner scanner = new Scanner(System.in);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Thread write = new Thread() {
            public void run() {
                String message = null;
                try {
                    message = in.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (message != null) {
                    System.out.println(message);
                }
            }
        };

        Thread read = new Thread() {
            public void run() {
                out.println(scanner.nextLine());
            }
        };

        while(true) {
            write.run();
            read.run();
        }

    }

}
