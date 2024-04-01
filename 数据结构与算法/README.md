# 数据结构与算法
## 数据结构与算法的关系
- 数据结构是一门研究组织数据方法的学科
- 程序 = 数据结构 + 算法
- 数据结构是算法的基础
## 数据结构
- 线性结构：
    - **数据元素之间存在一对一**的线性关系
    - 两种不同的存储结构
        - 顺序存储结构
            - 顺序表中的**存储元素是连续的**
        - 链式存储结构
            - 链表中的存储元素**不一定是连续的**，元素节点中存放数据元素以及相邻元素的地址信息
    - 常见的线性结构：数组、队列、链表和栈
- 非线性结构
    - 非线性结构包括：二维数组、多维数组、广义表、树结构、图结构

## 稀疏数组
- 当一个数组大部分元素为0，或者为同一个值，可以使用稀疏数组来保存该数组
- 稀疏数组处理方法：
    1. 记录数组**一共有几行几列**，**有多少个不同**的值
    2. 把具有不同值的元素的行列以及值记录在一个小规模的数组中，从而缩小程序的规模
![sparseArray](img\sparseArray.png)
### 稀疏数组转换思路
- 二维数组转稀疏数组思路
    - 遍历原始的二维数组，得到有效数据的个数sum
    - 根据sum就可以创建稀疏数组sparseArr int[sum+1][3]
    - 将二维数组的有效数据存入到稀疏数组
- 稀疏数组转原始的二维数组
    - 先读取稀疏数组的第一行，根据第一行的数据创建原始二维数组
    - 在读取稀疏数组后几行的数据，并赋给原始的二维数组即可

```java
// 二维数组转稀疏数组
int sparseArr1[][] = new int[sum+1][3];
sparseArr1[0][0] = 11;
sparseArr1[0][1] = 11;
sparseArr1[0][2] = sum;

int count = 0;
for (int i = 0; i < 11; i++) {
    for (int j = 0; j < 11; j++) {
        if(chessArr1[i][j] != 0){
            count++;
            sparseArr1[count][0] = i;
            sparseArr1[count][1] = j;
            sparseArr1[count][2] = chessArr1[i][j];

        }
    }
}

System.out.println("-----------------------------------------");

// 稀疏数组转原始的二维数组
int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];

for (int i = 1; i < sparseArr2.length; i++) {
    chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
}
```
## 队列
- 队列是一个**有序列表**，可以用**数组**或是**链表**来实现
- 遵循**先入先出**的原则

### 数组模拟队列
- 队列本身是有序列表，使用数组的结构来存储队列数据需要以下声明
    - maxSize：队列的最大容量
    - front：队列前端
        - 随着数据输出而改变
    - rear：队列尾端
        - 随着数据输入而改变
- 增
    - addQueue
        - 将尾指针往后移：rear+1，当front == rear
        - 若尾指针rear小于队列的最大下标 maxSize-1，则将数据存入rear所指的数组元素中，否则无法存入数据，rear == maxSize-1
```java
// 优化前
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部的前一个位置
        rear = -1; // 指向队列最后一个数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d", i, arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("isEmpty");
        }
        return arr[front + 1];
    }

}
```

### 数组模拟环形队列
- 调整front变量的含义：front就指向队列的第一个元素，也就是说arr[front] 就是队列的第一个元素。front的初始值 = 0
- 调整rear变量含义：rear指向队列的最后一个元素的后一个位置 -> 希望空出一个空间作为约定。rear初始值 = 0
- 当队列满时，条件是`(rear + 1) % maxSize == front`
- 队列为空的条件，rear == front
- 队列中有效的数据个数：(rear + maxSize - front) % maxSize
```java
// 优化后
class CircleArray {
    private int maxSize;
    private int front; // 指向第一个元素index   默认0
    private int rear; // 指向最后一个元素index + 1  默认0
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];     // 数列最大有效数个数 = maxSize - 1
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        int i = arr[front];
        front = (front + 1) % maxSize;
        return i;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d", i % maxSize, arr[i % maxSize]);
        }
    }
    // Array中的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return arr[front];
    }

}
```

## 链表
- 链表是有序的列表
- 链表是以节点的方式来存储
- 每个节点包含data域，next域
- 链表的各个节点**不一定是连续存储**
- 链表分**带头结点的链表**和**没有头节点的链表**
### 单链表
- head节点：
    - 不存放具体的数据
    - 作用是表示单链表头
- 添加
    1. 先创建一个head头节点，作用是表示单链表的头
    2. 后面每添加一个节点，就直接加到链表的最后
- 插入
    1. 先找到新添加节点的位置，通过辅助指针
    2. 新节点next = temp.next
    3. 将temp.next = 新节点 
- 删除
    1. 找到需要删除的节点的前一个节点
    2. temp.next = temp.next.next
    3. 被删除的节点将不会有其他引用指向，会被垃圾回收机制回收
```java
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
}
```