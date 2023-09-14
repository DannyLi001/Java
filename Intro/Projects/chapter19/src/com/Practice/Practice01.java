package com.Practice;

import java.io.*;

/**
 * @author
 */
public class Practice01 {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader br = new BufferedReader(isr);

        int count = 0;
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(++count + " " + str);
        }
        br.close();
    }
}
