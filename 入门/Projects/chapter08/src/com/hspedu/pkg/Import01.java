package com.hspedu.pkg;

// 建议只导入需要的类
//import java.util.Scanner; // 引入java.util 包下的Scanner
//import java.util.*; // 将java.util 包下的所有类都引入

import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,4,1,3};
        // 排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }
}
