package com.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile(){
        FileOutputStream fileOutputStream = null;
        String filePath = "d:\\";

        try {
            fileOutputStream = new FileOutputStream(filePath);
            String str = "hello";

            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
