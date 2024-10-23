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

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while(true) {

            out.println(new Scanner(System.in).nextLine());
            String serverMessage = in.readLine();
            System.out.println(serverMessage == null ? "CONNECTION CLOSED" : serverMessage);
        }

    }

}
