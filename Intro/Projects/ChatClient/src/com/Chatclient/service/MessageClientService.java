package com.Chatclient.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author
 */
public class MessageClientService {

    public void sendMessageToOne(String content, String senderID, String receiverID){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderID);
        message.setReceiver(receiverID);
        message.setSendTime(new Date().toString());
        message.setContent(content);
        System.out.println(senderID + " says " + content+ " to "+ receiverID);
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectionThread.getClientConnectionServerThread(senderID).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String content, String senderID){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL);
        message.setSender(senderID);
        message.setSendTime(new Date().toString());
        message.setContent(content);
        System.out.println(senderID + " says " + content+ " to everyone");
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectionThread.getClientConnectionServerThread(senderID).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
