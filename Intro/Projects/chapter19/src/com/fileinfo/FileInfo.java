package com.fileinfo;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author
 */
public class FileInfo {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        File file = new File("d:\\text.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        file.delete();
        file.list();
    }
}
