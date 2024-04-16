package DataStructure;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add");
            System.out.println("list");
            System.out.println("find");
            System.out.println("exit");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "find":
                    System.out.println("id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTab(int size) {
        empLinkedListsArray = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListsNO = hashFun(emp.id);
        empLinkedListsArray[empLinkedListsNO].append(emp);
    }

    public void list() {
        for (EmpLinkedList empLinkedList : empLinkedListsArray) {
            empLinkedList.list();
        }
    }

    public void findEmpById(int id) {
        int empLinkedListsNO = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListsNO].findEmpById(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("noFound");
        }
    }

    // 编写一个散列函数
    public int hashFun(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    private Emp head;

    // add
    public void append(Emp emp) {
        Emp temp = head;
        if (temp == null) {
            head = emp;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
        return;
    }

    // insert
    // change
    // list
    public void list() {
        if (head == null) {
            System.out.println("isEmpty");
            return;
        }
        Emp temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();
        return;
    }

    // find
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("isEmpty");
        }
        Emp temp = head;
        while (temp != null) {
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
}

// 雇员 结点
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + "]";
    }
}
