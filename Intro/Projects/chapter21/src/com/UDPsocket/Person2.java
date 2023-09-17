package com.UDPsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author
 */
public class Person2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6060);

        byte[] data = "hello".getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.100"), 9999);

        socket.send(packet);

        byte[] bytes = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length);

        socket.receive(packet1);
        System.out.println(new String(packet1.getData(),0,packet1.getLength()));
        socket.close();
    }
}
