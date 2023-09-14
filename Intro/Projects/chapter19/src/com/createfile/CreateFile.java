package com.createfile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author
 */
public class CreateFile {
    public static void main(String[] args) {

    }

    @Test
    public void create01(){
        String filePath = "d:\\text.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void create02(){
        File parentFile = new File("d:\\");
        String fileName = "test.txt";

        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create03(){
        String parentPath = "d:\\";
        String fileName = "file.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
