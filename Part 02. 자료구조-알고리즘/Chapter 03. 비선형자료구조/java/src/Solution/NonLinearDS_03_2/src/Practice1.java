package Solution.NonLinearDS_03_2.src;// 비선형 자료구조 - 이진 탐색 트리_2
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
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public Node rightRotate(Node node) {
        Node lNode = node.left;

        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }

    public Node leftRotate(Node node) {
        Node rNode = node.right;

        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    public Node lrRotate(Node node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public Node rlRotate(Node node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    public void insert(int key) {
        this.head = insert(this.head, key);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, null, null);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        // LL
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // LR
        if (balance > 1 && key > node.left.key) {
            return lrRotate(node);
        }

        // RL
        if (balance < -1 && key < node.right.key) {
            return rlRotate(node);
        }

        return node;
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
