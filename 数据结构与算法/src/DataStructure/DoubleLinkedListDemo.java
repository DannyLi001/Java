package DataStructure;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        HeroNode2 h1 = new HeroNode2(1, "name1", "n1");
        HeroNode2 h2 = new HeroNode2(2, "name2", "n2");
        HeroNode2 h3 = new HeroNode2(3, "name3", "n3");
        HeroNode2 h4 = new HeroNode2(4, "name4", "n4");
        HeroNode2 h4_1 = new HeroNode2(4, "name4-1", "n4-1");
        
        dll.add(h4);
        dll.addByOrder(h2);
        dll.addByOrder(h1);
        dll.addByOrder(h3);
        dll.update(h4_1);

        dll.delete(4);
        dll.show();
        
    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0, null, null);

    public HeroNode2 getHead() {
        return head;
    }

    
    public void add(HeroNode2 heroNode) {
        // 因为head不能动，我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    public void addByOrder(HeroNode2 heroNode){
        // temp找到位于添加位置的前一个节点
        HeroNode2 temp = head;

        while (temp.next != null) {
            if(temp.next.no > heroNode.no){
                break;
            } else if(temp.next.no == heroNode.no){
                System.out.println("isExist");
                return;
            }
            temp = temp.next;
        }
        if (temp.next != null){
            temp.next.pre = heroNode;
        }
        heroNode.next = temp.next;
        heroNode.pre = temp;
        temp.next = heroNode;
        return;
    }
    
    public void update(HeroNode2 heroNode){
        if(head.next == null){
            System.out.println("isEmpty");
            return;
        }

        HeroNode2 temp = head;
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
        if (head.next == null){
            System.out.println("isEmpty");
            return;
        }

        HeroNode2 temp = head.next;
        while(temp != null){
            if(temp.no == no){
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                temp.pre.next = temp.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("noFound");
    }
    
    public void show() {
        if (head.next == null) {
            System.out.println("isEmpty");
            return;
        }

        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
        return;
    }
    
}


class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2 [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}