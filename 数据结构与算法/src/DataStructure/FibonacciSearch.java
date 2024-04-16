package DataStructure;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = { 6, 15, 85, 99, 105, 124, 168, 205};
        System.out.println(fibSearch(arr, 168));
    }

    // 需要先获取到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法
     * 使用非递归方法
     * 
     * @param arr
     * @param key 需要查找的关键值
     * @return
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();
        // 1、1、2、3、5、8、13、21、34……
        // 如果数组有6个数，f[k]会取8，k=5
        // 如果数组有5个数，f[k]会取5，k=4
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k]值可能大于arr的长度，我们需要用Arrays构造一个新数组，并指向temp
        // 不足部分用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
