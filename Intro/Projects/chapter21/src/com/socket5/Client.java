package com.socket5;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("sending");
        writer.write("song2");
        writer.newLine();
        writer.flush();
        socket.shutdownOutput();




        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        System.out.println("receiving");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();

        String filePath = "src\\song1.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        System.out.println("saving");
        bufferedOutputStream.write(array);
        bufferedOutputStream.close();
        bis.close();



        writer.close();
        socket.close();

    }
}
