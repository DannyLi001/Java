package com.UDPsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author
 */
public class Person1 {
    public static void main(String[] args) throws IOException {
        // 创建DatagramSocket对象, 准备在9999端口接收
        DatagramSocket socket = new DatagramSocket(9999);
        // 构建一个DatagramPacket对象, 准备接收
        // 数据报最大64k
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

        // 调用接收方法, 将通过网络传输的DatagramPacket对象
        // 填充到packet对象
        // 当数据报发送到本机9999端口时, 就会接收到数据
        // 如果没有数据报发送到, 就会堵塞
        socket.receive(datagramPacket);

        // 把packet拆包, 取出数据
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();

        String s = new String(data, 0, length);
        System.out.println(s);

        data = "hello, too".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.100"), 6060);
        socket.send(packet);
        socket.close();
    }
}
