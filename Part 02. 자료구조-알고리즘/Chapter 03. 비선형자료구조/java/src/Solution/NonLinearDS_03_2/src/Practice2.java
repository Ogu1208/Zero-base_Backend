package Solution.NonLinearDS_03_2.src;// AVL 트리 - 삭제

class AVLTree2 extends AVLTree{

    public void delete(int key) {
        this.head = delete(this.head, key);
    }

    public Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node predecessor = node;
                Node successor = node.left;

                while (successor.right != null) {
                    predecessor = successor;
                    successor = successor.right;
                }

                predecessor.right = successor.left;
                node.key = successor.key;
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        // LL
        if (balance > 1 && getBalance(node.left) > 0) {
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) < 0) {
            return leftRotate(node);
        }

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            return lrRotate(node);
        }

        // RL
        if (balance < - 1 && getBalance(node.right) > 0) {
            return rlRotate(node);
        }

        return node;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        AVLTree2 avl = new AVLTree2();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.levelOrder(avl.head);
        avl.delete(40);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.delete(10);     // RR
        avl.levelOrder(avl.head);

        avl.insert(25);
        avl.delete(40);     // LR
        avl.levelOrder(avl.head);

        avl.insert(27);
        avl.delete(20);     // RL
        avl.levelOrder(avl.head);
    }
}
