package com.Practice;

import java.io.*;

/**
 * @author
 */
public class Practice {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\mytemp";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        String txt = filePath + "\\txt";
        file = new File(txt);
        if (!file.exists()) {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txt));
            bufferedWriter.write("123");
            bufferedWriter.close();
        } else {
            System.out.println("fail");
        }

    }
}
