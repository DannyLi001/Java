package com.socket3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        String filePate = "src\\test.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePate));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(array);
        bis.close();
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();

        bufferedOutputStream.close();
        socket.close();

    }
}
