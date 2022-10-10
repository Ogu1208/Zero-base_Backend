package Practice.NonLinearDS_04.src;// Practice1
// 주어진 이진 탐색 트리에서 N 번째로 작은 수 구하기

// 입력 트리: 3, 1, 4, null, 2
// N: 1
// 결과: 1

// 입력 트리: 5, 3, 6, 2, 4, null, null, 1
// N: 3
// 결과: 3

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

    BinarySearchTree() {}
    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        this.head = this.addNode(this.head, key);
    }

    public Node addNode(Node cur, int key) {
        if (cur == null) {
            return new Node(key, null, null);
        }

        if (key < cur.key) {
            cur.left = addNode(cur.left, key);
        } else {
            cur.right = addNode(cur.right, key);
        }

        return cur;
    }
}

public class Practice1 {
    public static void solution(Integer[] data, int n) {

    }

    public static void main(String[] args) {
        // Test code
        Integer[] data = {3, 1, 4, null, 2};
        int n = 1;
        solution(data, n);

        data = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        n = 3;
        solution(data, n);
    }
}
