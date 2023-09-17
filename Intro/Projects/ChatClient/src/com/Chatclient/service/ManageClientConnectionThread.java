package com.Chatclient.service;

import java.util.HashMap;

/**
 * @author
 */
public class ManageClientConnectionThread {

    // K = userID, V = user thread
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    // put thread into map
    public static void addClientConnectionServerThread(String userID, ClientConnectServerThread clientConnectServerThread){
        hm.put(userID, clientConnectServerThread);
    }

    // get thread through userID
    public static ClientConnectServerThread getClientConnectionServerThread(String userID){
        return hm.get(userID);
    }
}
