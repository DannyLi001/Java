package com.bufferedcopy_;

import java.io.*;

/**
 * @author
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        String inputPath = "d:\\";
        String outputPath = "d:\\";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(inputPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputPath));

            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = bufferedInputStream.read(buf)) != -1){
                bufferedOutputStream.write(buf,0,readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
