package Practice.NonLinearDS_01.src;// Practice3
// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node2 head;

    BinaryTree3(char[] arr) {
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char data) {
        Queue<Node2> queue = new LinkedList<>();  // level 순회
        queue.add(this.head);
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            if (cur.data == data) {
                return cur;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data) {   // 자신을 포함한 자식 노드의 개수
        Node2 node = this.searchNode(data);

        Queue<Node2> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                size++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1; // 자기자신 포함
    }

}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println("Root: " + bt.head.data);


        // B's child node
        Node2 B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B -> left child: " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B -> right child: " + B.right.data);
        }


        // F's parent node
        Node2 F = bt.searchNode('F');
        System.out.println("F -> parent: " + B.parent.data);

        // Leaf node
        System.out.print("Leaf node: ");
        for (int i = 0; i < arr.length; i++) {
            Node2 cur = bt.searchNode((char) ('A' + i));

            if (cur.left == null && cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();


        // E's Depth
        Node2 E = bt.searchNode('E');
        Node2 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E depth: " + cnt);


        // Level2 Node
        System.out.println("Level2 node: ");
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }
            if (cnt == 2) {
                System.out.print(target.data + " ");
            }
        }
        System.out.println();


        // Height
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }

        System.out.println("Height: " + maxCnt);


        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B size = " + size);


    }
}
