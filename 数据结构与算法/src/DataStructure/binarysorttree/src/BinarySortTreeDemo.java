public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {8,7,9,4,6,5,3,1,2,0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        binarySortTree.delNode(5);
        binarySortTree.infixOrder();
    }
}
class BinarySortTree {
    private Node root;
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("isEmpty");
        }
    }
    public Node search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    public Node searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    /**
     * 删除目标节点下 与目标值最接近的节点值 并删除该节点
     * @param node  删除的目标节点
     * @return      与目标节点值最接近的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while(target.left != null) {
            target = target.left;
        }
        // 删除最接近值的节点（叶子节点）
        delNode(target.value);
        return target.value;
    }
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if(targetNode == null) {
                return;
            }
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parentNode = searchParent(value);
            // 目标节点是叶子节点
            if(targetNode.left == null && targetNode.right == null) {
                if(parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if(parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            // 目标节点有左右两个子节点
            } else if (targetNode.left != null && targetNode.right != null){
                // 目标节点下 与目标节点值最接近的节点值 并与之替换
                int minVal  = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            // 目标节点有一个子节点
            } else {
                if(targetNode.left != null) {
                    if(parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if(parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    // 添加
    public void add(Node node) {
        if(node == null) {
            return;
        }
        // 比较添加节点的值和添加节点的值
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
    // 查找节点
    public Node search(int value){
        if(value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    // 查找节点的父节点
    public Node searchParent(int value) {
        if((this.left != null && this.left.value == value) || 
        (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果当前节点比目标节点大 向左递归
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            // 如果当前节点比目标节点小 向右递归
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
    public void infixOrder(){
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    
}
