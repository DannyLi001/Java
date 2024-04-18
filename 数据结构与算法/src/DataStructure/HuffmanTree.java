package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = { 6, 4, 8, 2, 1, 5, 3, 7, 9 };
        Node head  = createHuffmanTree(arr);
        head.preOrder();
    }
    
    public static Node createHuffmanTree(int[] arr) {
        // 遍历数组并为每个元素创建一个Node
        // 将所有Node放到ArrayList
        List<Node> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        while(nodes.size() > 1){
            // 从小到大排序
            Collections.sort(nodes);
            // 取出最小
            Node left = nodes.get(0);
            // 取出第二小
            Node right = nodes.get(1);
            // 构建一个新二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            // 从ArrayList中删除处理过的节点
            nodes.remove(left);
            nodes.remove(right);
            // 将parent添加回ArrayList
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

// 实现Comparable接口来完成比较
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}