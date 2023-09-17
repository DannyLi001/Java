package com.socket5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("waiting");

        Socket accept = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        String str = reader.readLine();
        System.out.println(str);
        String filePath = "";
        if(str.equals("song1")){
            filePath = "src\\test.jpg";
        } else {
            filePath = "src\\default.jpg";
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(accept.getOutputStream());

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        System.out.println("sending");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();

        outputStream.write(array);
        System.out.println("finish");
        accept.shutdownOutput();
        bis.close();
        outputStream.close();
        reader.close();
        accept.close();
        serverSocket.close();
    }
}
