package com.socket2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 9999端口监听 不能有其他程序在同一个Socket监听
        ServerSocket serverSocket = new ServerSocket(9999);
        // 当没有客户端连接9999端口，程序会堵塞，等待连接
        // 如果有客户端连接, 则会返回Socket对象, 程序继续
        // ServerSocket可以通过accept返回多个Socket[多并发/多个客户端连接服务器的并发]
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        System.out.println(br.readLine());

        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("this is server");
        bw.newLine();
        bw.flush();


        accept.shutdownOutput();
        // 关闭输入流和socket
        bw.close();
        br.close();
        accept.close();
        serverSocket.close();


    }
}
