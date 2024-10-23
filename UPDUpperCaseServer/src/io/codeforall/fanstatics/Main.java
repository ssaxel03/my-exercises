package io.codeforall.fanstatics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean keepGoing = true;

        int localPort = 8080;

        DatagramSocket socket = new DatagramSocket(localPort);

        while(keepGoing) {
            byte[] recvBuffer = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);

            String uppercase = new String(recvBuffer, 0, receivePacket.getLength()).toUpperCase();
            uppercase = uppercase.replaceAll("\n", "");
            System.out.println(uppercase);

            if(uppercase.equals("Q")) {
                socket.close();
                System.exit(0);
            }

            byte[] sendBuffer = (uppercase + "\n").getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

        }

    }


}
