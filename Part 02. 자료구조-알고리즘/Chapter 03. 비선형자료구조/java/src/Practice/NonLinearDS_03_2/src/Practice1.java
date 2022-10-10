package Practice.NonLinearDS_03_2.src;// 비선형 자료구조 - 이진 탐색 트리_2
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node head;

    public int height(Node node) {
        return 0;
    }

    public Node rightRotate(Node node) {
        return null;
    }

    public Node leftRotate(Node node) {
        return null;
    }

    public Node lrRotate(Node node) {
        return null;
    }

    public Node rlRotate(Node node) {
        return null;
    }

    public int getBalance(Node node) {
        return 0;
    }

    public void insert(int key) {
    }

    public Node insert(Node node, int key) {
        return null;
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        AVLTree avl = new AVLTree();

        // Insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);     // RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);      // LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);     // RL
        avl.levelOrder(avl.head);
    }
}
