package com.socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket accept = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();

        String filePath = "src\\test2.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));

        bufferedOutputStream.write(array);
        bufferedOutputStream.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write("accepted");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bis.close();
        bufferedWriter.close();
        accept.close();
        serverSocket.close();
    }
}
