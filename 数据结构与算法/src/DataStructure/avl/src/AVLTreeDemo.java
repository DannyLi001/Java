public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 10,11,7,6,8,9 };
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.infixOrder();
    }
}

class AVLTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("isEmpty");
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除目标节点下 与目标值最接近的节点值 并删除该节点
     * 
     * @param node 删除的目标节点
     * @return 与目标节点值最接近的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
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
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parentNode = searchParent(value);
            // 目标节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
                // 目标节点有左右两个子节点
            } else if (targetNode.left != null && targetNode.right != null) {
                // 目标节点下 与目标节点值最接近的节点值 并与之替换
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
                // 目标节点有一个子节点
            } else {
                if (targetNode.left != null) {
                    if (parentNode != null) {
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parentNode != null) {
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

    public Node getRoot() {
        return root;
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    private void leftRotate() {
        Node newNode = new Node(value);
        // 新节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 新节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        // 把当前结点的值替换为右子节点的值
        value = right.value;
        // 把当前右子节点替换为右子节点的右子节点
        right = right.right;
        // 把当前左子节点替换成新节点
        left = newNode;
    }

    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        right = newNode;
        left = left.left;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    // 添加
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 比较添加节点的值和添加节点的值
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        // 当添加完一个节点后，如果 右子树的高度-左子树高度 > 1，左旋转
        if (rightHeight() - leftHeight() > 1) {
            // 如果 右子节点的左子树高度>右子节点的右子树高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                // 先对右子树进行右旋转
                right.rightRotate();
                // 再对当前节点进行左旋转
                leftRotate();
            }else {
                leftRotate();
            }
            // 当添加完一个节点后，如果 左子树的高度-右子树高度 > 1，右旋转
        } else if (leftHeight() - rightHeight() > 1) {
            // 如果 左子节点的右子树高度>左子节点的左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                // 先对左子树进行左旋转
                left.leftRotate();
                // 再对当前节点进行右旋转
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    // 查找节点
    public Node search(int value) {
        if (value == this.value) {
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
        if ((this.left != null && this.left.value == value) ||
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

    public void infixOrder() {
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
