package Practice.NonLinearDS_03_3.src;// 비선형 자료구조 - 이진 탐색 트리_3
// Red-Black 트리 - 삽입

class Node {
    int key;
    int color;
    Node left;
    Node right;

    public Node(int key, int color, Node left, Node right, Node parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    Node parent;
}

class RedBlackTree {
    static final int BLACK = 0;
    final int RED = 1;

    Node head;

    public void insert(int key) {
        Node checkNode = null;  // 새롭게 데이터 추가해서 새롭게 rebalancing이 필요할때 집어놓을변수
        if (this.head == null) {
            this.head = new Node(key, BLACK, null, null, null);  // 헤드는 항상 black
        } else {
            Node cur = this.head;

            while (true) {
                Node pre = cur;

                if (key < cur.key) {
                    cur = cur.left;
                    if (cur == null) {  // 추가할 위치
                        pre.left = new Node(key, RED, null, null, pre);
                        checkNode = pre.left;
                        break;
                    }
                } else {
                    cur = cur.right;

                    if (cur == null) {
                        pre.right = new Node(key, RED, null, null, pre);
                        checkNode = pre.right;
                        break;
                    }
                }
            }
//            reBalance(checkNode);
        }
    }

    public void reBalance(Node node) {
        while (node.parent != null && node.parent.color == RED) {
            Node sibling = null;

            if (node.parent == node.parent.parent.left) {
                sibling = node.parent.parent.right;
            } else {
                sibling = node.parent.parent.left;
            }

            if (sibling != null && sibling.color == RED) {
                node.parent.color = BLACK;
                sibling.color = BLACK;
                node.parent.parent.color = RED;

                if (node.parent.parent == this.head) {   // parent.parent가 루트였으면
                    node.parent.parent.color = BLACK;
                    break;
                }
            } else {
                if (node.parent == node.parent.parent.left) {
                    if (node == node.parent.right) {
                        node = node.parent;
                        // 회전
                    }
                }
            }

        }
    }

    public void leftRotate(Node node) {
        if (node.parent == null) {
            Node rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            rNode.parent = null;
            this.head = rNode;
        } else {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    public void rightRotate(Node node) {
        if (node.parent == null) {
            Node lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        } else {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != null) {
                node.left.right.parent = node;
            }

            node.left = node.left.right;
            node.parent.right = node;
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
//        RedBlackTree rbTree = new RedBlackTree();
//        rbTree.insert(20);
//        rbTree.insert(10);
//        rbTree.insert(30);
//        rbTree.levelOrder(rbTree.head);
//        rbTree.insert(25);
//        rbTree.levelOrder(rbTree.head);
//        rbTree.insert(5);
//        rbTree.insert(7);
//        rbTree.levelOrder(rbTree.head);
//        rbTree.insert(20);
//        rbTree.levelOrder(rbTree.head);
    }
}
