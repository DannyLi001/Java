package DataStructure;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    
    // 对preOrder重载
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 
     * @param index     数组下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("isEmpty");
        }
        System.out.println(arr[index]);
        if((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}