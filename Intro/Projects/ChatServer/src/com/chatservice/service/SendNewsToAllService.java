package com.chatservice.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author
 */
public class SendNewsToAllService implements Runnable {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while(true) {
            System.out.println("Enter the news you want to send to everyone[q to exit]: ");
            String news = scanner.next();
            if(news.equals("q")){
                break;
            }
            Message message = new Message();
            message.setSender("Server");
            message.setContent(news);
            message.setMesType(MessageType.MESSAGE_TO_ALL);
            message.setSendTime(new Date().toString());
            System.out.println("News: " + news);

            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Set<String> keySet = hm.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                ServerConnectClientThread serverConnectClientThread = hm.get(next);
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
