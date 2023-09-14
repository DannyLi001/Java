package com.printstream_;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        // 修改打印流输出位置
        System.setOut(new PrintStream("d:\\text.txt"));
        ps.write("oijoasf".getBytes());
        ps.close();
    }
}
