package com.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 连接InetAddress.getLocalHost()这台主机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 通过socket获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 通过输出流 写入数据到数据通道
        outputStream.write("hello server".getBytes());

        
        // 关闭流对象和socket 必须关闭
        outputStream.close();
        socket.close();

    }
}
