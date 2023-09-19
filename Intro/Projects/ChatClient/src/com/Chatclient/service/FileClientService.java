package com.Chatclient.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.*;

/**
 * @author
 */
public class FileClientService {

    public void sendFileToOne(String src, String dest, String senderID, String receiverID){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setReceiver(receiverID);
        message.setSender(senderID);
        message.setSrc(src);
        message.setDest(dest);

        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\n" + senderID + " sends " + src + " " + " to " + receiverID);

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectionThread.getClientConnectionServerThread(senderID).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
