package DataStructure;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = { 6, 1, 8, 7, 3, 4 };
        int index = seqSearch(arr, 5);
        System.out.println(index);
    }

    /**
     * 线性查找
     * 
     * @param arr
     * @param val
     * @return
     */
    public static int seqSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
