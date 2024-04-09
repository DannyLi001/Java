package DataStructure;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 8, 0, 4, 6, 4, 7, 3, 8 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        int temp = 0;
        while (l < r) {
            // 找到左边大于等于pivot
            while (arr[l] < pivot) {
                l++;
            }
            // 找到右边小于等于pivot
            while (arr[r] > pivot) {
                r--;
            }
            // 左边小于pivot，右边大于pivot
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 抓着和pivot相等的数，往中间靠
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
