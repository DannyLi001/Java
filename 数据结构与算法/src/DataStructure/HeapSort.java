package DataStructure;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 7, 8, 9, 6, 4, 5, 1, 3, 2 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int temp;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    // 将一个数组调整成大顶堆
    /**
     * 将以i对应的非叶子节点的树调整成大顶堆
     * 
     * @param arr
     * @param i      表示非叶子节点的索引
     * @param length 表示对多少个元素调整
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];
        // j = i * 2 + 1 i的左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++; // 右子节点
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        // 已经将以i为父节点的树的最大值放在了堆顶
        arr[i] = temp;
    }
}
