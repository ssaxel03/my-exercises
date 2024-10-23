package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket1 = serverSocket.accept();

        PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
        BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));

        out1.println("WAITING FOR USER TO CHAT");

        Socket clientSocket2 = serverSocket.accept();

        PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
        BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

        out1.println("READY TO CHAT");
        out2.println("READY TO CHAT");

        while(true) {

            String in1Str = in1.readLine();
            String in2Str = in2.readLine();

            if(!(in1Str == null)) {
                out2.println(in1Str);
            }

            if(!(in2Str == null)) {
                out1.println(in2Str);
            }
        }
    }

}
