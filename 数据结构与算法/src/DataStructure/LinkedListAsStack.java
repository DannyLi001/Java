package DataStructure;

public class LinkedListAsStack {
    public static void main(String[] args) {
        SLL sll = new SLL();
        Nd nd1 = new Nd("data1");
        Nd nd2 = new Nd("data2");
        Nd nd3 = new Nd("data3");

        sll.add(nd1);
        sll.add(nd2);
        sll.add(nd3);

        sll.show();
        System.out.println("--------------------------------------");
        System.out.println(sll.pop());
        System.out.println(sll.pop());
        System.out.println(sll.pop());
        System.out.println(sll.pop());
        System.out.println("--------------------------------------");
        sll.show();
    }
}

class SLL {
    private Nd head;

    public SLL() {
        head = new Nd(null);
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void add(Nd data){
        Nd temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(data);
        return;
    }

    public String pop() {
        if(isEmpty()){
            return "isEmpty";
        }
        Nd temp = head;
        while (temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        String data = temp.getNext().getData();
        temp.setNext(null);
        return data;
    }

    public void show(){
        if (head.getNext() == null){
            System.out.println("isEmpty");
            return;
        }

        Nd temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
            System.out.println(temp.getData());
        }
        return;
    }
    
}

class Nd {
    private String data;
    private Nd next;
    public Nd(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Nd getNext() {
        return next;
    }
    public void setNext(Nd next) {
        this.next = next;
    }
}