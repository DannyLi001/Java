package com.Chatclient.service;

import com.chatcommon.Message;
import com.chatcommon.MessageType;
import com.chatcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author
 */
public class UserClientService {
    private User user = new User();
    private Socket socket;

    // check if a user is valid
    public boolean checkUser(String userID, String pwd) {
        boolean b = false;
        user.setUserID(userID);
        user.setPwd(pwd);

        try {
            // trying to connect server
            socket = new Socket(InetAddress.getByName("192.168.0.100"), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();

            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                ClientConnectServerThread clientConnectServerThread =
                        new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                // manage thread in hashmap
                ManageClientConnectionThread.addClientConnectionServerThread(userID, clientConnectServerThread);
                b = true;

            } else {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return b;
    }

    // request for online user list
    public void onlineUserList(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_USERS);
        message.setSender(user.getUserID());
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectionThread.getClientConnectionServerThread(user.getUserID()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);

        message.setSender(user.getUserID());
       try {
           ObjectOutputStream oos =
                new ObjectOutputStream(ManageClientConnectionThread.getClientConnectionServerThread(user.getUserID()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(user.getUserID() + " exit");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
