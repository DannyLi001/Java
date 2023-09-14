package com.outputstream_;

import java.io.*;

/**
 * @author
 */
public class FileCopy {
    public static void main(String[] args) {
        String inputFilePath = "d:\\";
        String outputFilePath = "d:\\";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(inputFilePath);
            fileOutputStream = new FileOutputStream(outputFilePath);

            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
