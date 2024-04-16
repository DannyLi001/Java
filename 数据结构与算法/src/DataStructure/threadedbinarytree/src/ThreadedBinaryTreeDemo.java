package DataStructure.threadedbinarytree.src;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) throws Exception {
        Hero node1  = new Hero(1, "name1");
        Hero node2  = new Hero(3, "name3");
        Hero node3  = new Hero(6, "name6");
        Hero node4  = new Hero(8, "name8");
        Hero node5  = new Hero(10, "name10");
        Hero node6  = new Hero(14, "name14");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(node1);
        threadedBinaryTree.threadedNodes();
        System.out.println(node5.getRight());
        System.out.println("------------------------------------");
        threadedBinaryTree.threadedList();
    }
}

class ThreadedBinaryTree {
    private Hero root;
    // 线索化需要创建一个指向当前节点的前驱节点的指针
    private Hero pre;

    public void setRoot(Hero root) {
        this.root = root;
    }

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

    // 编写对二叉树进行中序线索化的方法
    /**
     * 
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

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
                return;
            }
            root.delNode(no);
        } else {
            System.out.println("isEmpty");
        }
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

    public Hero preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public Hero infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public Hero postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

class Hero {
    private int no;
    private String name;
    private Hero left;
    private Hero right;

    // 如果leftType == 0 表示指向的是左子树，如果 == 1 表示指向前驱节点
    // 如果rightType == 0 表示指向的是右子树，如果 == 1 表示指向后继节点
    private int leftType;
    private int rightType;

    public Hero(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /*
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
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getLeft() {
        return left;
    }

    public void setLeft(Hero left) {
        this.left = left;
    }

    public Hero getRight() {
        return right;
    }

    public void setRight(Hero right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Hero [no=" + no + ", name=" + name + "]";
    }
}