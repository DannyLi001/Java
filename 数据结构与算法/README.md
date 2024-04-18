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

## 时间复杂度
### 时间频度
- 一个算法花费的时间与算法中语句的执行次数成正比，算法中语句执行次数称为时间频度 T(n)
    - 常数项可以忽略    n + *10*
    - 低次项可以忽略    2n^2 + *n*
    - 系数可以忽略      *5*n^2
        - n^3 VS 6n^3 执行曲线分离，说明多少次方是关键
### 时间复杂度
- 某个辅助函数f(n)，当n趋近于无穷大时，T(n)/f(n) 的极限值为 不等于零的常数，则f(n)是T(n)的同数量级函数。记T(n) = O(f(n))
    - O(f(n)) 为时间复杂度
- T(n) 不同，但时间复杂度相同 eg. T(n) = n^2+7n+6 and T(n) = 3n^2+2n+2 ---> O(n^2)
- 计算时间复杂度：
    - 用常数1代替运行时间中的所有假发常数
    - 修改后的运行次数函数中，保留最高阶项
    - 去除最高项的系数

- 常见时间复杂度：
    - 常数阶：O(1)
    - 对数阶：O(log2 n)
    - 线性阶：O(n)
    - 线性对数阶：O(nlog2 n)
    - 平方阶：O(n^2)
    - 立方阶：O(n^3)
    - k次方阶：O(n^k)
    - 指数阶：O(2^n)

- 常数阶
    - 如果没有循环等复杂结构，时间复杂度O(1)
    - 消耗时间并不随着某个变量增大而增长
- 对数阶
    ```java
    int i = 1;
    while(i < n){
        i *= 2;
    }
    ```
    - while循环里每次*2，乘完后i距离n越来越近。假设循环x后，i大于n退出循环 -> 2的x次方大于n，那么 x = log2 n 时间复杂度O(log2 n)

- 线性阶
    - for循环

- 线性对数阶
    - 对数阶和线性阶的集合体，将时间复杂度为O(logn)的代码循环N遍

- 平方阶
    - 两个for循环嵌套

## 数组和字符串
### 集合、列表和数组
- 集合
    - 由一个或多个确定的元素所构成的整体。
        - 集合里的元素类型不一定相同
        - 集合里的元素没有顺序

- 列表
    - 是一种数据项构成的有限序列，即按照一定的线性顺序，排列而成的数据项的集合。
    - 列表的概念是在集合的特征上形成的，它具有顺序，且长度是可变的
        - 列表最常见的表现形式有数组和链表
        - 栈和队列则是两种特殊类型的列表

- 数组
    - 数组是列表的实现方式之一
    - 数组中的元素类型必须保持一致
    - 数组中的元素在内存中是连续存储的  
    - 数组与列表最大的不同点是列表中没有索引
    - 查找和删除：
        - 查找元素的时间复杂度为 O(N)
        - 删除操作时间复杂度为 O(N)
```java
/* 寻找数组的中心索引
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 */
public int pivotIndex(int[] nums) {
    int sum = 0;
    for(int i=0;i<nums.length;i++){
        sum += nums[i];
    }
    int left_sum = 0;
    for(int i=0;i<nums.length;i++){
        sum -= nums[i];
        if(left_sum == sum){
            return i;
        }
        left_sum += nums[i];
    }
    return -1;
}
```
```java
/* 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。请必须使用时间复杂度为 O(log n) 的算法。
 */
public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while(left <= right){
        int mid = (right - left) / 2 + left;
        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] > target){
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return left;
}
```

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

    // 添加
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取
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
```java
class SingleLinkedList {
    // 初始化头节点
    private HeroNode head = new HeroNode(0, null, null);
```
- 添加
    1. 先创建一个head头节点，作用是表示单链表的头
    2. 后面每添加一个节点，就直接加到链表的最后
```java
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
```

- 插入
    1. 先找到新添加节点的位置，通过辅助指针
    2. 新节点next = temp.next
    3. 将temp.next = 新节点 
```java
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

    // 修改
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
```

- 删除
    1. 找到需要删除的节点的前一个节点
    2. temp.next = temp.next.next
    3. 被删除的节点将不会有其他引用指向，会被垃圾回收机制回收
```java
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

    // 获取列表元素数量
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
```

- 查找倒数元素
    1. 获取链表元素个数
    2. 遍历链表 size - index 次
```java
    // 查找倒数元素
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
```

- 反转链表
    1. 定义一个新的头节点
    2. 遍历原来的链表，用插入的方式将元素依次添加到新链表的第一个位置
    3. 将原来的头节点指向新链表的第一个元素

```java
    // 单链表反转
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }

        HeroNode temp = head.next;  // 即将添加到新链表的元素
        HeroNode next = null;       // 添加到新链表元素的下一个元素
        HeroNode reverseHead = new HeroNode(0, null, null);
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;   // 插入到新链表的第一个位置
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }
```

- 逆序打印
    1. 利用栈，将节点压入到栈中（先进后出）

```java
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

    // 打印链表
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
// 节点类
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
### 双向链表
- 双向链表可以向前或向后查找
- 双向链表可以自我删除
- 遍历、添加、修改、删除
```java
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0, null, null);
    public HeroNode2 getHead() {
        return head;
    }
```
- 添加（默认添加到链表最后）
    - 先找到链表最后一个节点
    - temp.next = new HeroNode
    - new HeroNode.pre = temp
```java
    public void add(HeroNode2 heroNode) {
        // 因为head不能动，我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //插入
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
```
- 修改
    - 和单链表一样
```java
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
```
- 删除（可以实现自我删除某个节点）
    - 找到要删除的节点
    - temp.pre.next = temp.next
    - temp.next.pre = temp.pre  

```java
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
```
- 遍历方法和单链表一样，但是可以向前也可以向后
```java
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
```
- 节点类
```java
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
}
```
### 单向环形链表 
---
约瑟夫问题
- 设编号为1，2，...n的d个人围坐一圈，约定编号为k的人从1开始报数，数到m的那个人出列，他的下一位又从1开始报数，如此反复，直到所有人出列。由此产生一个出队编号的序列

---
构建单向链表：
- 创建第一个节点，让first指向该节点，并形成环形
- 每创建一个新节点，就把节点加入到已有的环形链表中

```java
class CircleSingleLinkedList {
    private Boy first = new Boy();
```
添加
- 第一个节点需要特别创建
- 添加后面节点时，需要两个指针，一个指向最开始的节点，一个指向新创建的节点
```java
    public void addBoy(int nums) {
        if (nums < 1) {
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }
```
约瑟夫问题solution
- 需要两个指针，一个指向报数报到的小孩，一个指向该小孩后面的节点
- 先将需要取出的节点进行操作，然后将指向该节点的指针向前进一位
- 将后面的指针指向前进一位的节点即可去除操作完的节点
```java
    /**
     * 
     * @param startNo  从第几个小孩开始数数
     * @param countNum 数几下
     * @param nums     最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("wrongParam");
        }

        // 创建一个helper指针，指向first后面
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        // 从第startNo个小孩开始
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始报数
        while (true) {
            if (helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first.getNo());
    }
```
遍历：
- 创建一个辅助指针，指向first节点
- 通过while循环遍历环形链表 curBoy.next == first

```java
    public void showBoy() {
        if (first == null) {
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}
// 节点类
class Boy {
    private int no;
    private Boy next;
}
```

## 栈 stack
- 先进后出的有序列表
- 栈是限制线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表。允许插入和删除的一端称为栈顶，另一端称为栈底。

### 数组模拟栈
- 定义top表示栈顶，初始为-1
- 入栈：stack[top++] = data;
- 出栈：return stack[top--];
```java
class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    public boolean isFull() {
        return top == maxSize - 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    // 添加
    public void push(int value) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 获取
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return stack[top--];
    }

    // 遍历
    public void show() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
```
### 使用栈实现计算器 (中缀表达式)
- 准备两个栈：数字栈，符号栈
- 通过所以来遍历数学公式
- 如果是数字，直接如数字栈
- 如果是符号
    - 如果符号栈为空，入符号栈
    - 如果符号栈有符号，对当前符号和栈顶符号的优先级进行比较
        - 如果当前符号优先级小于或等于栈顶符号，从数字栈中取出两个数字，符号栈中取出一个符号进行运算，将得到的结果放入数字栈，然后将当前符号加入到符号栈。
        - 如果当前符号优先级大于栈顶符号，入符号栈
- 数学公式扫描完毕，按顺序从数字栈和符号栈中pop出对应的数和符号并运行
- 最后数字栈中只有一个数字，就是公式结果

```java
public static void main(String[] args) {
    String exp = "31+2*60-2";
    ArrayStack2 numbers = new ArrayStack2(10);
    ArrayStack2 operators = new ArrayStack2(10);

    int index = 0;
    int num1 = 0;
    int num2 = 0;
    int oper = 0;
    int res = 0;
    char ch = ' ';
    String keepNum = "";

    while (true) {
        ch = exp.substring(index, index + 1).charAt(0);
        if (operators.isOper(ch)) {
            if (operators.isEmpty()) {
                operators.push(ch);
            } else {
                if (operators.priority(ch) <= operators.priority(operators.peek())) {
                    num1 = numbers.pop();
                    num2 = numbers.pop();
                    oper = operators.pop();

                    res = numbers.cal(num1, num2, oper);
                    numbers.push(res);
                    operators.push(ch);
                } else {
                    operators.push(ch);
                }
            }
        } else {
            keepNum += ch;
            if (index == exp.length() - 1) {
                numbers.push(Integer.parseInt(keepNum));
            } else {
                if (operators.isOper(exp.substring(index + 1, index + 2).charAt(0))) {
                    numbers.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
        }
        index++;
        if (index >= exp.length()) {
            break;
        }
    }
    while (true) {
        if (operators.isEmpty()) {
            break;
        }
        num1 = numbers.pop();
        num2 = numbers.pop();
        oper = operators.pop();

        res = numbers.cal(num1, num2, oper);
        numbers.push(res);
    }
    System.out.println(numbers.pop());
}


class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
```

## 前缀、中缀、后缀表达式
### 前缀
- 从右至左扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数。用运算符对它们做相应的计算，并将结果入栈；重复上述过程直到表达式最左端，最后运算得出的值即为结果
    - (3+4)*5-6 前缀表达式为 - * + 3 4 5 6
### 中缀
- 中缀表达式是常见的运算表达式 (3+4)*4-6
- 计算机不好操作
### 后缀
- 逆波兰表达式
- 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数。用运算符对它们做相应的计算，并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为结果
    - (3+4)*5-6 前缀表达式为 3 4 + 5 * 6 -
    - 4*5-8+60+8/2 -> 4 5 * 8 - 60 + 8 2 / +

### 逆波兰计算器
```java
public static void main(String[] args) {
    String suffixExpression = "3 4 + 5 * 6 -";
    List<String> rpnList = getListString(suffixExpression);
    int res = calculate(rpnList);
    System.out.println(res);
}

public static List<String> getListString(String suffixExpression) {
    String[] split = suffixExpression.split(" ");
    ArrayList<String> list = new ArrayList<>();
    for (String ele : split) {
        list.add(ele);
    }
    return list;
}

public static int calculate(List<String> ls) {
    Stack<String> stack = new Stack<>();
    for (String item : ls) {
        if (item.matches("\\d+")) {
            stack.push(item);
        } else {
            int num2 = Integer.parseInt(stack.pop());
            int num1 = Integer.parseInt(stack.pop());
            int res = 0;
            if (item.equals("+")) {
                res = num1 + num2;
            } else if (item.equals("-")) {
                res = num1 - num2;
            } else if (item.equals("*")) {
                res = num1 * num2;
            } else if (item.equals("/")) {
                res = num1 / num2;
            } else {
                throw new RuntimeException();
            }
            stack.push(res + "");
        }
    }
    return Integer.parseInt(stack.pop());
}
```

### 中缀转后缀表达式
1. 初始化了两个栈，运算符栈s1和储存中间结 果栈s2
2. 从左至右扫描中缀表达式
3. 遇到操作数时，压入s2
4. 遇到运算符时，比较其与s1栈顶运算符的优先级：
    1. 如果s1为空，或栈顶运算符为左括号 "(" 则直接将此运算符入栈
    2. 如果优先级比栈顶运算符的高，将运算符压入s1
    3. 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
5. 遇到括号
    1. 如果是左括号 "(" 直接压入s1
    2. 如果是右括号 ")" 则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
6. 重复步骤2至5，直到表达式的最右边
7. 将s1中剩余的运算符依次弹出并压入s2
8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
```java
public static List<String> parseSuffixExpressionList(List<String> ls) {
    Stack<String> s1 = new Stack<>();
    // s2没有pop操作，后续还需要逆序操作，使用ArrayList
    ArrayList<String> s2 = new ArrayList<>();

    for (String item  : ls) {
        if(item.matches("\\d+")){
            s2.add(item);
        } else if (item.equals("(")){
            s1.push(item);
        } else if(item.equals(")")){
            while (!s1.peek().equals("(")){
                s2.add(s1.pop());
            }
            s1.pop();
        } else {
            while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                s2.add(s1.pop());
            }
            s1.push(item);
        }
    }
    while (s1.size() != 0) {
        s2.add(s1.pop());
    }
    return s2;
}
```

## 递归
- 当程序执行到一个方法时，会开辟一个独立的空间（栈）
- 每个空间的数据是独立的
- 递归必须向退出递归的条件逼近，否则StackOverflowEffor
- 当方法执行完毕或遇到return就会返回，遵守谁调用，就将返回值给谁。
### 迷宫问题
```java
/* 
 * 从地图（1，1）出发
 * 如果到达（6，5）说明找到通路
 * 约定：0表示没有走过，1表示墙，2表示可以走，3表示已经走过，但是不通
 * 策略：下->右->上->左，如果不通，回溯
 */
/**
 * 
 * @param map 地图
 * @param i   从哪个位置开始找
 * @param j
 * @return 如果找到返回true 否则false
 */
public static boolean setWay(int[][] map, int i, int j) {
    if (map[6][5] == 2) {
        return true;
    } else {
        if(map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay(map, i+1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)){
                return true;
            } else if (setWay(map, i - 1, j)){
                return true;
            } else if (setWay(map, i, j - 1)){
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
```
### 八皇后问题
```java
int max = 8;
int[] array = new int[max];

public static void main(String[] args) {    
    Queen queen = new Queen();
    queen.check(0);
}

private void check(int n) {
    if (n == max) {
        print();
        return;
    }
    for (int i = 0; i < max; i++) {
        array[n] = i;

        if(judge(n)) {
            check(n + 1);
        }
    }
}

private boolean judge(int n){
    for (int i = 0; i < n; i++) {
        // array[i] == array[n] 检查是否在同一列
        // Math.abs(n - i) == Math.abs(array[n] - array[i]) 检查是否在同一斜线
        if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
            return false;
        }
    }
    return true;
}

private void print(){
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i]);
    }
    System.out.println();
}
```

## 排序
内部排序  
- 指将需要处理的所有数据都加载到内部储存器中进行排序  

    - 插入排序
        - 直接插入排序
        - 希尔排序
    - 选择排序
        - 简单选择排序
        - 堆排序
    - 交换排序
        - 冒泡排序
        - 快速排序
    - 归并排序
    - 基数排序  

外部排序
- 数据量过大，无法全部加载到内存中，需要借助外部储存进行排序

### 冒泡排序
- 一共进行数组大小 -1 次大循环
- 每一趟排序的次数在逐渐减少
- 如果发现在某趟排序中没有发生一次交换，可以提前结束排序（优化）
![bubblesort](img\bubblesort.gif)
```java
public static void bubbleSort(int[] arr){
    // 时间复杂度O(n^2)
    int temp = 0;
    boolean flag = false; // 标识变量，表示是否进行过交换
    // i - 1 不需要循环所有元素
    for (int i = 0; i < arr.length - 1; i++) {
        // j - 1 确保不超出边界
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                flag = true;
            }
        }
        if (!flag) {
            break;
        } else {
            flag = false;
        }
    }
}
```

### 选择排序
- 选择排序一共有数组大小-1 轮排序
- 每一轮排序，又是一个循环，循环的规则
    - 先假定当前这个数是最小数
    - 然后和后面的每个数进行比较，如果发现有比当前数更小的数就重新确定最小数，并得到下表
    - 当遍历到数组最后时，就得到本轮最小数和下标
    - 交换
![selectsort](img\selectsort.gif)
```java
public static void selectSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        int min = arr[i];
        // 找最小数
        for (int j = i + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                minIndex = j;
                min = arr[j];
            }
        }
        // 交换
        if (minIndex != i) {
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
```

### 插入排序
- 开始时有序表中只包含一个元素，无序表中包含n-1个元素
- 排序过程中每次从无序表中取出第一个元素，把它的值与有序表元素的值进行比较，将它插入到有序表中适当的位置，成为新的有序表
![insertionSort](img\insertionSort.gif)
```java
public static void insertSort(int[] arr) {
    int insertVal = 0;
    int insertIndex = 0;
    // i之前都为有序，之后为需要整理的部分
    for (int i = 1; i < arr.length; i++) {
        insertVal = arr[i];
        insertIndex = i - 1;

        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
    }
}   
```

#### 希尔排序（插入排序优化）
按下表进行一定增量分组，对每组使用直接插入排序算法排序，随着增量减少，每组包含的元素越来越多，当增量减至1，给整个队列分为一组并进行插入排序
![shellsort](img\shellsort.gif)
- 交换法
```java
public static void shellSort(int[] arr) {
    int temp = 0;
    
    for (int gap = arr.length / 2; gap > 0; gap/=2) {
        // 分组
        for (int i = gap; i < arr.length; i++) {
            // 遍历各组中的元素
            for (int j = i - gap; j >= 0; j -= gap) {
                // 交换
                if (arr[j] > arr[j + gap]){
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
    }
}
```
- 移位法
```java
public static void shellSort2(int[] arr) {
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            if (arr[j] < arr[j - gap]) {
                // 移位
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
}
```

### 快速排序
- 通过一趟排序将要排序的数据分割成独立的两部分，一部分的数据比另一部分的数据都要小，然后再按照此方法对两部分数据进行快速排序，整个排序过程可以递归进行
![quicksort](img\quicksort.gif)
```java
public static void quickSort(int[] arr, int left, int right) {
    int l = left;
    int r = right;
    int pivot = arr[(left + right) / 2];

    int temp = 0;
    while (l < r) {
        // 找到左边大于pivot
        while (arr[l] < pivot) {
            l++;
        }
        // 找到右边小于pivot
        while (arr[r] > pivot) {
            r--;
        }
        // 左边小于pivot，右边大于pivot
        if (l >= r) {
            break;
        }
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        if (arr[l] == pivot) {
            r--;
        }
        if (arr[r] == pivot) {
            l++;
        }
    }

    if (l == r) {
        l++;
        r--;
    }
    if (left < r) {
        quickSort(arr, left, r);
    }
    if (right > l) {
        quickSort(arr, l, right);
    }
}
```

### 归并排序
- 采用分治策略
    - **分**成一些小的问题，然后递归求解
    - **治**是将分的阶段得到的各答案“修补”在一起
![mergesort](img\mergesort.gif)
```java
public static void mergeSort(int[] arr, int left, int right, int[] temp){
    if(left < right){
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }
}

/**
    * 
    * @param arr   排序的原始数组
    * @param left  左边有序序列的初始索引
    * @param mid   中间索引
    * @param right 右边索引
    * @param temp  做中转的数组
    */
public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
    int i = left;
    int j = mid + 1;
    int t = 0;

    // 先把左右两边的数据按照规则填充到temp数组
    // 直到左右两边的有序序列，有一边处理完毕为止
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[t] = arr[i];
            t++;
            i++;
        } else {
            temp[t] = arr[j];
            j++;
            t++;
        }
    }
    // 把有剩余数据的一边，依次全部填充到temp
    while (i <= mid) {
        temp[t] = arr[i];
        t++;
        i++;
    }
    while (j <= right) {
        temp[t] = arr[j];
        t++;
        j++;
    }

    t = 0;
    int tempLeft = left;
    while (tempLeft <= right) {
        arr[tempLeft] = temp[t];
        tempLeft++;
        t++;
    }
}
```
### 基数排序（桶排序）
- 将所有带比较数值统一为同样的数位长度，数位较短的数前补零。从最低为开始，一次进行依次排序。这样从最低位排序一直到最高位排序完成后，数列就变成一个有序序列。
- 空间换时间，内存占用大
![radixsort](img\radixsort.gif)
```java
public static void radixSort(int[] arr) {
    // 数组中最大的位数
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    int maxLength = (max + "").length();
    // 定义一个二维数组，表示10个桶
    // 为了防止溢出，每个一维数组大小为arr.length
    int[][] bucket = new int[10][arr.length];

    // 用来记录每个桶的数据数量
    int[] bucketElementCounts = new int[10];

    for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
        // 入桶
        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] / n % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
        }

        // 出桶
        int index = 0;
        for (int k = 0; k < bucket.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            // 清桶
            bucketElementCounts[k] = 0;
        }
    }
}
```
### 常用排序算法对比
![allsorts](img\allsorts.png)

## 查找
### 线性查找
```java
public static int seqSearch(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == val) {
            return i;
        }
    }
    return -1;
}
```
### 二分查找
- 只能对于有序数列进行查找
- 首先确定数组中间下标
- 对比findVal 和 arr[mid]
    - findVal > arr[mid] 说明要找的数在mid右边，向右递归
    - findVal < arr[mid] 说明要找的数在mid左边，向左递归
    - findVal == arr[mid] 说明找到，返回
- 递归结束
    - 找到并返回
    - 没有找到，左指针>右指针，退出
```java
/**
 * 二分查找
 * @param arr     数组
 * @param left    左边索引
 * @param right   右边索引
 * @param findVal 要找的值
 * @return
 */
public static int binarySearch(int[] arr, int left, int right, int findVal) {
    if (left > right) {
        return -1;
    }
    int mid = (left + right) / 2;
    int midVal = arr[mid];

    if (findVal > midVal) {
        return binarySearch(arr, mid + 1, right, findVal);
    } else if (findVal < midVal) {
        return binarySearch(arr, left, mid - 1, findVal);
    } else {
        return mid;
    }
}
```
- 拓展
    - 找到多个相同值的下标
    ```java 
    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            // 找到值不用马上返回
            // 向左向右扫描
            // 将Arraylist返回
            ArrayList<Integer> list  = new ArrayList<>();
            int temp = mid - 1;
            while(true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }

            list.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
    ```

### 插值查找
- 同样只适用于有序数列
- 不同于二分查找，插值查找取中间点的算法不同
    - ![insertvaluesearch](img\insertvaluesearch.png)
- 对于数据量较大，关键字分布比较均匀时，插值查找速度较快
- 关键字分布不均匀的情况下，该方法不一定比二分查找快
```java
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
```

### 斐波那契查找
- 和插值查找相似，只是更改了中间结点的获取算法
- ![fibonaccisearch](img\fibonaccisearch.png)
```java
// 需要先获取到一个斐波那契数列
public static int[] fib() {
    int[] f = new int[maxSize];
    f[0] = 1;
    f[1] = 1;
    for (int i = 2; i < maxSize; i++) {
        f[i] = f[i - 1] + f[i - 2];
    }
    return f;
}

/**
 * 斐波那契查找算法
 * 使用非递归方法
 * @param arr
 * @param key 需要查找的关键值
 * @return
 */
public static int fibSearch(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    int k = 0;
    int mid = 0;
    int f[] = fib();
    // 1、1、2、3、5、8、13、21、34……
    while (high > f[k] - 1) {
        k++;
    }
    // 因为f[k]值可能大于arr的长度，我们需要用Arrays构造一个新数组，并指向temp
    // 不足部分用0填充
    int[] temp = Arrays.copyOf(arr, f[k]);
    for (int i = high + 1; i < temp.length; i++) {
        temp[i] = arr[high];
    }
    while (low <= high ) {
        mid = low + f[k - 1] - 1;
        if(key < temp[mid]) {
            high = mid - 1;
            k--;
        } else if (key > temp[mid]) {
            low = mid + 1;
            k -= 2;
        } else {
            return high;
        }
    }
    return -1;
}
```

## 哈希表
- 根据关键码值（key value）而直接进行访问的数据结构。通过把关键码值映射到表中一个位置来访问记录，以加快查找速度。映射函数叫散列函数，存放记录的数组叫散列表
- 可以用来作为缓存层
    - 缓存产品
        - Redis
        - Memcache

```java
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
}
```
## 树结构
- 提高数据存储，读取的效率。既可以保证数据检索速度，同时也可以保证数据的插入，删除，修改的速度
### 二叉树
- 每个节点最多只能有两个节点
- 二叉树的子节点分为左节点和右节点
- 如果所有叶子节点都在最后一层，并且节点总数2^(n-1),n为层数，则称为满二叉树
- 如果二叉树的所有叶子节点都在最后一层和倒数第二层，而且最后一层的叶子节点在左边连续，倒数第二层叶子节点在右边连续，称为完全二叉树
#### 前中后序遍历
- 前序
    - 先输出当前节点
    - 如果左节点不为空，则递归继续前序遍历
    - 如果右节点不为空，则递归继续前序遍历
- 中序
    - 如果左节点不为空，则递归继续中序遍历
    - 输出当前节点
    - 如果右节点不为空，则递归继续前序遍历
- 后序
    - 如果左节点不为空，则递归继续中序遍历
    - 如果右节点不为空，则递归继续前序遍历
    - 输出当前节点
```java
// 树类
class BinaryTree {
    private Hero root;

    public void setRoot(Hero root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("isEmpty");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("isEmpty");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("isEmpty");
        }
    }
}
// 节点类
class Hero {
    private int no;
    private String name;
    private Hero left;
    private Hero right;

    public Hero(int no, String name) {
        this.no = no;
        this.name = name;
    }
    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    // 后续遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }
}
```
#### 前中后序查找
- 前序
    - 判断当前节点是否为所需节点
    - 如果是，返回当前节点
    - 如果不是，则判断当前节点的左节点是否为空，如果不是，则递归谦虚查找
    - 如果左递归前序查找，找到节点，则返回，否则继续判断，当前节点的右节点是否为空，如果不是，则继续向右递归前序查找
- 中序
    - 判断当前节点的左节点是否为空，如果不为空，则递归中序查找
    - 如果找到，则返回，如果没有找到，就和当前节点比较，如果是则返回当前节点，否则继续向右递归中序查找
    - 如果右递归中序查找，找到就返回，否则返回null
- 后序
    - 判断当前节点的节点是否为空，如果不为空，则递归后序查找
    - 如果找到，则返回，如果没有找到，就判断当前节点的右节点是否为空，如果不为空，则右递归进行后序查找，如果找到就返回
    - 就和当前节点进行，如果是则返回，否则返回null
```java
public Hero preOrderSearch(int no) {
    // 比较当前节点是不是
    if (this.no == no) {
        return this;
    }
    // 判断当前节点的左节点是否为空，如果不为空，则递归前序查找
    // 如果左递归前序查找找到节点，则返回
    Hero resNode = null;
    if (this.left != null) {
        resNode = this.left.preOrderSearch(no);
    }
    if (resNode != null) {
        return resNode;
    }
    // 判断右节点是否为空，如果不是，则向右递归前序查找
    if (this.right != null) {
        resNode = this.right.preOrderSearch(no);
    }
    return resNode;
}

public Hero infixOrderSearch(int no) {
    Hero resNode = null;
    if (this.left != null) {
        resNode = this.left.infixOrderSearch(no);
    }
    if (resNode != null) {
        return resNode;
    }
    if (this.no == no) {
        return this;
    }
    if (this.right != null) {
        resNode = this.right.infixOrderSearch(no);
    }
    return resNode;
}

public Hero postOrderSearch(int no) {
    Hero resNode = null;
    if (this.left != null) {
        resNode = this.left.postOrderSearch(no);
    }
    if (resNode != null) {
        return resNode;
    }
    if (this.right != null) {
        resNode = this.right.postOrderSearch(no);
    }
    if (resNode != null) {
        return resNode;
    }
    if (this.no == no) {
        return this;
    }
    return resNode;
}
```
#### 删除节点
- 如果删除的节点是叶子节点，则删除该节点
- 如果删除的节点是非叶子节点，则删除该树
```java
// 在二叉树类中
public void delNode(int no) {
    if (root != null){
        if(root.getNo() == no) {
            root = null;
            return;
        }
        root.delNode(no);
    } else {
        System.out.println("isEmpty");
    }
}

/* 在节点类中
 * 因为这个二叉树是单向的，所以我们是判断当前节点的子节点是否需要
 * 删除节点，而不能去判断当前节点是否需要删除
 */
public void delNode(int no) {
    // 如果当前节点的左节点不为空，且是需要删除的节点，就将this.left = null 并返回
    // 如果this.left 为空，this.left.no 会报错
    if (this.left != null && this.left.no == no) {
        this.left = null;
        return;
    }
    // 同理如上
    if (this.right != null && this.right.no == no) {
        this.right = null;
        return;
    }
    // 向左递归删除
    if(this.left != null){
        this.left.delNode(no);
    }
    if(this.right != null){
        this.right.delNode(no);
    }  
}
```
#### 顺序存储二叉树
- 数组存储方式和树的存储方式可以相互转换
- 顺序存储二叉树的特点
    - 顺序二叉树通常只考虑完全二叉树
    - 第n个元素的左子节点为2*n+1
    - 第n个元素的右子节点为2*n+2
    - 第n个元素的父节点为(n-1)/2
    - n表示二叉树的第几个元素（从0开始编号）
```java
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
```
#### 线索化二叉树
- n个节点的二叉链表中有n+1个空指针域。利用二叉链表中的空指针域，存放指向该节点的某种遍历次序下的前驱和后继节点的指针。这种附加的指针称为“线索”
- 这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树（Threaded Binary Tree）。根据线索性质不同，线索二叉树可以分为前序线索二叉树，中序线索二叉树和后序线索二叉树
- 一个结点的前一个节点称为前驱节点
- 一个节点的后一个节点称为后继节点
- 当线索化二叉树后，Node节点的属性left和right，有如下情况：
    - left指向左子树，也可能指向前驱节点
    - right指向右子树，也可能指向后继节点
```java
// 中序线索化二叉树
// 二叉树类中
private Hero pre;

// 编写对二叉树进行中序线索化的方法
/**
 * @param node 当前需要线索化的节点
 */
public void threadedNodes() {
    this.threadedNodes(root);
}

public void threadedNodes(Hero node) {
    if (node == null) {
        return;
    }
    // 先线索化左子树
    threadedNodes(node.getLeft());
    // 线索化当前节点
    // 先处理当前节点的前驱节点
    if (node.getLeft() == null) {
        // 左指针指向前驱节点，并修改当前左指针的类型
        node.setLeft(pre);
        node.setLeftType(1);
    }
    // 处理后继节点，前驱节点的后继节点指向当前节点
    if (pre != null && pre.getRight() == null) {
        pre.setRight(node);
        pre.setRightType(1);
    }
    pre = node;
    // 线索化右子树
    threadedNodes(node.getRight());
}
```
- 遍历线索化二叉树
    - 通过线型方式遍历，因此无需使用递归方式，提高效率
    ```java
    // 遍历线索化二叉树
    public void threadedList() {
        Hero node = root;
        while(node != null) {
            // 循环的找到leftType == 1的节点
            // 说明该节点是按照线索化处理后的有效节点
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while(node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历节点
            node = node.getRight();
        }
    }
    ```
### 堆排序
- 堆排序是利用树结构而设计的排序算法，是一种选择排序。最坏，最好，平均时间复杂度均为O(nlogn)，它是不稳定排序
- 具有以下性质的完全二叉树：每个节点的值都大于或等于其左右子节点的值，称为大顶堆。注意，没有要求左节点和右节点的值大小关系
- 每个结点的值都小于或等于左右子节点的值，称为小顶堆
- 升序使用大顶堆，降序使用小顶堆
    1. 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
    2. 将堆顶元素与末尾元素交换，将最大元素放到数组末端
    3. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换，直到整个序列有序
```java
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
```

### 赫夫曼树
- 给定n个权值作为n个叶子节点，构造一棵二叉树，若该树的带权路径长度达到最小，称之为最优二叉树，也称赫夫曼树。
    - 路径和路径长度：在一棵树中，从一个节点往下可以达到的孩子或孙子节点之间的通路，称为路径。通路中分支的数目称为路径长度。若规定根节点的层数为1，则从根节点到L层节点的路径长度为L-1
    - 节点的权及带权路径长度：若将树中节点赋给一个有意义的数值，该数值称为权。节点的带权路径长度：从根节点到该节点之间的路径长度与该节点的权的乘积。
    - 数的带权路径长度：树的带权路径长度规定为所有叶子节点的带权路径长度之和，即为WPL（weighted path length），权值越大的节点离根节点越近的二叉树才是最优二叉树
    - WPL最小的就是赫夫曼树
```java
public static Node createHuffmanTree(int[] arr) {
    // 遍历数组并为每个元素创建一个Node
    // 将所有Node放到ArrayList
    List<Node> nodes = new ArrayList<>();
    for (int val : arr) {
        nodes.add(new Node(val));
    }
    while(nodes.size() > 1){
        // 从小到大排序
        // Node实现了Comparable接口
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
```
### 赫夫曼编码
- 电讯通信中的经典的应用之一
- 应用于数据文件压缩，压缩率通常在20-90之间
- 赫夫曼码是可变长编码（VLC）的一种 
- 原理剖析
    - 定长编码
        - 根据字符串中的字符在ascii码中的编号进行编码，然后转换成二进制
    - 变长编码
        - 将字符串中的每个字符进行统计。对每种字符重新编码，再按字符串中的顺序编辑原字符串。字符的编码不能是其他字符编码的前缀，符合此要求的叫前缀编码，既 不能匹配到重复的编码
    - 赫夫曼编码
        - 将字符进行统计，把字符出现的频率当作权重。通过赫夫曼树，对字符进行编码。左子节点为0，右子节点为1。
        - 赫夫曼树会根据创建树的顺序不一样而不一样但是压缩后的大小是一样的
    
    ![huffman](img\huffman.gif)
```java
// 将字符转成节点并进行统计
private static List<Node1> getNode1s(byte[] bytes) {
    ArrayList<Node1> Node1s = new ArrayList<>();
    HashMap<Byte, Integer> counts = new HashMap<>();
    // 统计每个字符的频率
    for (byte b : bytes) {
        Integer count = counts.get(b);
        if (count == null) {
            counts.put(b, 1);
        } else {
            counts.put(b, ++count);
        }
    }
    // 将字符和其频率包装，放在节点中
    for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
        Node1s.add(new Node1(entry.getKey(), entry.getValue()));
    }
    return Node1s;
}
```
```java
// 生成赫夫曼树
private static Node1 createHuffmanTree(List<Node1> nodes) {
    while (nodes.size() > 1) {
        Collections.sort(nodes);
        Node1 left = nodes.get(0);
        Node1 right = nodes.get(1);

        Node1 parent = new Node1(null, right.weight + left.weight);
        parent.left = left;
        parent.right = right;

        nodes.remove(left);
        nodes.remove(right);
        nodes.add(parent);
    }
    return nodes.get(0);
}
```
```java
// 根据生成的赫夫曼树，对字符进行编码，获得编码表
static StringBuilder stringBuilder = new StringBuilder();
static Map<Byte, String> huffmanCodes = new HashMap<>();

/**
 * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合
 * 
 * @param node          节点
 * @param code          路径：左子节点0，右子节点1
 * @param stringBuilder 用于拼接路径
 */
private static void getCodes(Node1 node, String code, StringBuilder stringBuilder) {
    StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
    stringBuilder2.append(code);
    if (node != null) {
        // 向左，向右递归
        if (node.data == null) {    // 非叶子节点
            getCodes(node.left, "0", stringBuilder2);
            getCodes(node.right, "1", stringBuilder2);
        } else {
            huffmanCodes.put(node.data, stringBuilder2.toString());
        }
    }
}
// 方法重载
private static Map<Byte, String> getCodes(Node1 root) {
    if (root == null) {
        return null;
    }
    getCodes(root.left, "0", stringBuilder);
    getCodes(root.right, "1", stringBuilder);
    return huffmanCodes;
}
```
```java
/**
 * 对照编码表，将原来的字符数组进行编码，再按照字符大小重新排版，返回字符数组
 * @param bytes         原始字符串对应的byte[]
 * @param huffmanCodes  生成的赫夫曼编码map
 * @return              返回赫夫曼编码处理后的byte[]
 */
private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
    // 利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
    StringBuilder stringBuilder = new StringBuilder();

    for (byte b : bytes) {
        stringBuilder.append(huffmanCodes.get(b));
    }
    // 将stringBuilder转成byte[]
    int len;
    if (stringBuilder.length() % 8 == 0) {
        len = stringBuilder.length() / 8;
    } else {
        len = stringBuilder.length() / 8 + 1;
    }
    // 创建存储压缩后的byte数组
    byte[] huffmanCodeBytes = new byte[len];
    int index = 0;
    for (int i = 0; i < stringBuilder.length(); i += 8) {
        String strByte;
        if (i + 8 > stringBuilder.length()) {
            strByte = stringBuilder.substring(i);
        } else {
            strByte = stringBuilder.substring(i, i + 8);
        }
        huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
        index++;
    }
    return huffmanCodeBytes;
}
```
```java
/**
 * 使用一个方法，将前面的方法封装
 * @param bytes 原始的字符串对应的字节数组
 * @return      经过赫夫曼编码处理后的字节数组
 */
private static byte[] huffmanZip(byte[] bytes) {
    // 给每个字节创建节点 
    List<Node1> Node1s = getNode1s(bytes);
    // 创建赫夫曼树
    Node1 head = createHuffmanTree(Node1s);
    // 赫夫曼编码表
    Map<Byte, String> huffmanCodes = getCodes(head);
    // 生成赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
    byte[] zip = zip(bytes, huffmanCodes);
    return zip;
}
```