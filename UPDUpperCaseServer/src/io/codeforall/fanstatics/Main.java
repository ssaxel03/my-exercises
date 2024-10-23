package io.codeforall.fanstatics;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws IOException {

        int localPort = 8080;

        DatagramSocket socket = new DatagramSocket(localPort);

        while(true) {
            byte[] recvBuffer = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);

            String uppercase = new String(recvBuffer, 0, receivePacket.getLength()).toUpperCase();

            byte[] sendBuffer = uppercase.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

        }

    }


}
