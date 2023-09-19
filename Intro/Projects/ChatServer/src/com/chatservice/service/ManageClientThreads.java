package com.chatservice.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    // add thread to hashmap
    public static void addClientThread(String userID, ServerConnectClientThread thread) {
        hm.put(userID, thread);
    }

    // get thread from hashmap
    public static ServerConnectClientThread getServerConnectClientThread(String userID) {
        return hm.get(userID);
    }

    public static String getOnlineUsers() {
        Set<String> keySet = hm.keySet();
        String users = "";
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            users += iterator.next().toString() + " ";
        }
        return users;
    }

    public static void removeServerConnectClientThread(String userID){
        hm.remove(userID);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}
