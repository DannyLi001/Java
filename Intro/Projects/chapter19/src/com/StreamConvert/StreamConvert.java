package com.StreamConvert;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author
 */
public class StreamConvert {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "utf8");
        osw.write("jasdofi");
        osw.close();
    }

    @Test
    public void InputStreamToReader() throws IOException{
        // 读取gbk编码格式文件
        String filePath = "d:\\";
        // 先读取字节流, 再用InputStreamReader把字节改成字符, 然后再用缓冲流去编辑
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        System.out.println(str);
        br.close();

    }
}
