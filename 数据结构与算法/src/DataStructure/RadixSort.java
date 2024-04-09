package DataStructure;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 91, 73, 82, 44, 65, 56, 27, 18, 39, 0 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 数组中最大的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        // 定义一个二维数组，表示10个桶
        // 为了防止溢出，每个一维数组大小为arr.length
        int[][] bucket = new int[10][arr.length];

        // 用来记录每个桶的数据数量
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 入个位桶
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }

            // 出桶
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 清桶
                bucketElementCounts[k] = 0;
            }
        }
    }
}
