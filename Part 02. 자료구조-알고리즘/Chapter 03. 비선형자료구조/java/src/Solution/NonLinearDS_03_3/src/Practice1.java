package Solution.NonLinearDS_03_3.src;// 비선형 자료구조 - 이진 탐색 트리_3
// Red-Black 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    int color;
    Node left;
    Node right;
    Node parent;

    public Node(int key, int color, Node left, Node right, Node parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree {
    static final int BLACK = 0;
    static final int RED = 1;

    Node head;

    public void insert(int key) {
        Node checkNode = null;
        if (this.head == null) {
            // 처음 헤드는 Black
            this.head = new Node(key, BLACK, null, null, null);
        } else {
            Node cur = this.head;

            // 추가할 위치 찾아 추가하는 부분
            while (true) {
                Node pre = cur;

                if (key < cur.key) {
                    // 왼쪽 자식 노드 쪽으로 추가
                    cur = cur.left;
                    if (cur == null) {
                        // 추가할 때는 우선 Red
                        pre.left = new Node(key, RED, null, null, pre);
                        // 추가한 노드를 re-balancing 대상의 노드로 짚어줌
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
            // 추가 후 re-balancing
            reBalance(checkNode);
        }
    }

    public void reBalance(Node node) {
        // 추가한 노드의 부모가 있고 그 부모가 red 일 때 조정 필요
        while (node.parent != null && node.parent.color == RED) {
            Node sibling = null;

            // 부모 노드의 형제 노드 찾기
            if (node.parent == node.parent.parent.left) {
                sibling = node.parent.parent.right;
            } else {
                sibling = node.parent.parent.left;
            }

            // 부모 노드의 형제 노드가 Red 일 때 re-coloring
            if (sibling != null && sibling.color == RED) {
                // 부모 노드 black 으로 변경
                node.parent.color = BLACK;
                // 부모 노드의 형제 노드 black 으로 변경
                sibling.color = BLACK;
                // 부모의 부모 노드는 red 로 변경
                node.parent.parent.color = RED;

                // 부모 노드가 root 인 경우는 다시 black 으로 바꾸고 break
                if (node.parent.parent == this.head) {
                    node.parent.parent.color = BLACK;
                    break;
                } else { // 부모 노드가 root 가 아닌 경우는 double red 재발생 할 수 있으므로 반복 검사
                    node = node.parent.parent;
                    continue;
                }
            } else { // 부모 노드의 형제 없거나 black 일 때, re-structuring
                if (node.parent == node.parent.parent.left) {
                    // lr case 인 경우 우선 ll case 가 되도록 회전
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    // 부모 노드는 black 으로 변경
                    node.parent.color = BLACK;
                    // 부모의 부모 노드는 red 로 변경
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                } else if (node.parent == node.parent.parent.right) {
                    // rl case 인 경우 rr case 가 되도록 회전
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(Node node) {
        // node 가 head 인 경우 회전 후 head 교체
        if (node.parent == null) {
            Node rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            rNode.parent = null;
            this.head = rNode;
        } else {
            // 회전하기 전 자식 노드있는 경우 이동하는 작업
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
        // node 가 head 인 경우 회전 후 head 교체
        if (node.parent == null) {
            Node lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        } else {
            if (node == node.parent.left)
                node.parent.left = node.left;
            else
                node.parent.right = node.left;

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != null)
                node.left.right.parent = node;

            node.left = node.left.right;
            node.parent.right = node;
        }
    }

    public void levelOrder(Node node) {
        char[] color = {'B', 'R'};

        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print("[" + color[cur.color] + "]" + cur.key + " ");
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
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);
    }
}
