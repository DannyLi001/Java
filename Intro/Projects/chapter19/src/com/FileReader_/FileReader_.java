package com.FileReader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "d:\\";
        int data;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);

            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void readFile01() {

        String filePath = "d:\\";
        int readLen = 0;
        char[] buf = new char[8];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);

            while ((readLen = fileReader.read()) != -1) {
                System.out.println(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
