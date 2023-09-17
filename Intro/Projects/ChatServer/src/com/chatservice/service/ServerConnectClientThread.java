package com.chatservice.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;

    private String userID;

    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("waiting for " + userID + " data");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_USERS)){
                    // asking for online user list
                    System.out.println(message.getSender()+" request for online user list");
                    String onlineUsers = ManageClientThreads.getOnlineUsers();
                    // create and set return message
                    Message m = new Message();
                    m.setMesType(MessageType.MESSAGE_RET_ONLINE_USERS);
                    m.setContent(onlineUsers);
                    m.setReceiver(message.getSender());

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                    oos.writeObject(m);

                }
                if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender() + " want to exit");
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();

                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
