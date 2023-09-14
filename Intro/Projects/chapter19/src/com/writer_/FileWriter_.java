package com.writer_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author
 */
public class FileWriter_ {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        String filePath = "d:\\";
        char[] chars = {'a','b','c'};
        try {
             fileWriter = new FileWriter(filePath);
             fileWriter.write('H');
             fileWriter.write(chars);
             fileWriter.write("ksdfjow", 0, 3);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
