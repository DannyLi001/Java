package com.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress host = InetAddress.getByName("LAPTOP-KHRKSM31");
        System.out.println(host);

        InetAddress web = InetAddress.getByName("www.baidu.com");
        System.out.println(web);

        String hostAddress = host.getHostAddress();
        System.out.println(hostAddress);

        String hostName = web.getHostName();
        System.out.println(hostName);
    }
}
