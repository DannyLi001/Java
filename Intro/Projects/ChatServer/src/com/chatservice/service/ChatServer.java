package com.chatservice.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;
import com.chatcommon.User;

import javax.security.auth.login.CredentialNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author
 */
public class ChatServer {
    private ServerSocket serverSocket = null;

    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
    }

    private boolean checkUser(String userID, String pwd){
        User user = validUsers.get(userID);
        if (user == null){
            return false;
        }
        if (!user.getPwd().equals(pwd)){
            return false;
        }
        return true;
    }

    public ChatServer(){
        System.out.println("port 9999 is listening");
        try {
            serverSocket = new ServerSocket(9999);
            while(true){
                Socket socket = serverSocket.accept();

                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());

                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());

                User user = (User) ois.readObject();

                Message message = new Message();

                if(checkUser(user.getUserID(), user.getPwd())){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    // create a thread to keep connecting with client
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserID());
                    serverConnectClientThread.start();
                    ManageClientThreads.addClientThread(user.getUserID(), serverConnectClientThread);


                } else {
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close stream
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
