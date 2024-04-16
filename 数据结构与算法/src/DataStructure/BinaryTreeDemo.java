package DataStructure;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Hero node1 = new Hero(1, "name1");
        Hero node2 = new Hero(2, "name2");
        Hero node3 = new Hero(3, "name3");
        Hero node4 = new Hero(4, "name4");
        Hero node5 = new Hero(5, "name5");
        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.preOrder();
        System.out.println("------------------------------------");
        binaryTree.infixOrder();
        System.out.println("------------------------------------");
        binaryTree.postOrder();
        System.out.println("------------------------------------");
        // System.out.println(binaryTree.preOrderSearch(3));
        // System.out.println(binaryTree.infixOrderSearch(3));
        // System.out.println(binaryTree.postOrderSearch(3));
        binaryTree.delNode(3);
        binaryTree.postOrder();
    }

}

class BinaryTree {
    private Hero root;

    public void setRoot(Hero root) {
        this.root = root;
    }

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
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
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

    @Override
    public String toString() {
        return "Hero [no=" + no + ", name=" + name + "]";
    }
}