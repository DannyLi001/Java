package DataStructure;

import java.util.HexFormat;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        HeroNode h1 = new HeroNode(1, "name1", "n1");
        HeroNode h2 = new HeroNode(2, "name2", "n2");
        HeroNode h3 = new HeroNode(3, "name3", "n3");
        HeroNode h4 = new HeroNode(4, "name4", "n4");
        HeroNode h4_1 = new HeroNode(4, "name4_1", "n4_1");
        sll.addByOrder(h1);
        sll.addByOrder(h4);
        sll.addByOrder(h2);
        sll.addByOrder(h3);
        sll.update(h4_1);
        sll.delete(1);
        sll.show();

        int length = SingleLinkedList.getLength(sll.getHead());
        System.out.println(length);

        HeroNode node = SingleLinkedList.findLastIndexNode(sll.getHead(), 4);
        System.out.println(node);

        SingleLinkedList.reverseList(sll.getHead());
        sll.show();

        System.out.println("-----------------------------");

        SingleLinkedList.reversePrint(sll.getHead());
        
    }
}

class SingleLinkedList {
    // 初始化头节点
    private HeroNode head = new HeroNode(0, null, null);

    // 添加节点
    // 当不考虑编号顺序，将最后节点的next指向新节点
    public void add(HeroNode heroNode) {
        // 因为head不能动，我们需要一个辅助遍历temp
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    
    public void addByOrder(HeroNode heroNode){
        // temp找到位于添加位置的前一个节点
        HeroNode temp = head;

        while (temp.next != null) {
            if(temp.next.no > heroNode.no){
                break;
            } else if(temp.next.no == heroNode.no){
                System.out.println("isExist");
                return;
            }
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
        return;
    }

    public void update(HeroNode heroNode){
        if(head.next == null){
            System.out.println("isEmpty");
            return;
        }

        HeroNode temp = head;
        while(temp != null){
            if(temp.no == heroNode.no){
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                return;
            }
            temp = temp.next;
        }
        System.out.println("noFound");
    }

    public void delete(int no){
        HeroNode temp = head;
        while(temp.next != null){
            if(temp.next.no == no){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("noFound");
    }

    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int count = 0;
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if (head.next == null){
            return null;
        }

        int size = getLength(head);
        if(index <= 0 || index > size){
            return null;
        }

        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 单链表反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }

        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, null, null);
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            stack.push(temp);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("isEmpty");
            return;
        }

        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
        return;
    }

    public HeroNode getHead() {
        return head;
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}