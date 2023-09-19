package com.Chatclient.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author
 */
public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("waiting from server message");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // may be stuck when there's no message getting in
                Message message = (Message) ois.readObject();

                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_USERS)) {
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("=======Currently Online Users=========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println((i + 1) + ". User: " + onlineUsers[i]);
                    }
                }
                if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
                    System.out.println("\n" + message.getSender() + " says to everyone: " + message.getContent());
                }
                if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println("\n" + message.getSender() + " says: " + message.getContent());
                }
                if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + " sends a file to " + message.getReceiver());
                    System.out.println("Store at default path: " + message.getDest());
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("saved");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
