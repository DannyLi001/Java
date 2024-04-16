package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        // 查找数组必须是有序的
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 11, 15, 19 };
        List index = binarySearch2(arr, 0, arr.length - 1, 11);
        System.out.println(index);
    }

    /**
     * 二分查找
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 要找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    // 拓展
    // 找到所有数值相同的下标
    
    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            // 找到值不用马上返回
            // 向左向右扫描
            // 将Arraylist返回
            ArrayList<Integer> list  = new ArrayList<>();
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }

}
