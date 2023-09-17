package com.Chatclient.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author
 */
public class ClientConnectServerThread extends Thread{
    private Socket socket;

    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("waiting from server message");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // may be stuck when there's no message getting in
                Message message = (Message) ois.readObject();

                if(message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_USERS)){
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("=======Currently Online Users=========");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println((i+1) + ". User: " + onlineUsers[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket(){
        return socket;
    }
}
