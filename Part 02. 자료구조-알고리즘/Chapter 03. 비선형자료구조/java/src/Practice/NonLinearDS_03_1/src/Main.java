package Practice.NonLinearDS_03_1.src;// 비선형 자료구조 - 이진 탐색 트리

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {

    }

    public void removeNode(int key) {

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


public class Main {
    public static void main(String[] args) {
        // Test code
        // 노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
