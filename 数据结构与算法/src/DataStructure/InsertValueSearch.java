package DataStructure;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int [100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        
    }

    
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        // findVal < arr[0] || findVal > arr[arr.length - 1]
        // 是必要检查条件，否则如果findVal太大，可能会导致后面arr[mid]越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 自适应算法
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
