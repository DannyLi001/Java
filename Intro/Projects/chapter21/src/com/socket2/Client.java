package com.socket2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 连接InetAddress.getLocalHost()这台主机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 通过socket获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        // 通过输出流 写入数据到数据通道
        bw.write("hello server");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(br.readLine());
        // 关闭流对象和socket 必须关闭
        br.close();
        bw.close();
        socket.close();

    }
}
