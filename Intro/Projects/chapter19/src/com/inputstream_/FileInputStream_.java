package com.inputstream_;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile01(){
        String filePath = "d:\\text.txt";
        FileInputStream fileInputstream = null;
        int read = 0;
        try {
             fileInputstream = new FileInputStream(filePath);
            while((read = fileInputstream.read()) != -1){
                System.out.print((char)read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputstream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void readFile02(){
        String filePath = "d:\\text.txt";
        FileInputStream fileInputstream = null;
        int read = 0;
        int readLen = 0;
        byte[]  buf = new byte[8];
        try {
            fileInputstream = new FileInputStream(filePath);
            while((readLen = fileInputstream.read(buf)) != -1){
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputstream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
