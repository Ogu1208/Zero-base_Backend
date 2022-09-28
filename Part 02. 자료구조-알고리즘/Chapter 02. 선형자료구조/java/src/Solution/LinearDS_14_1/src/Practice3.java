package Solution.LinearDS_14_1.src;

class Node {
    int data;
    int cmd;
    boolean visited;
    Node next;
    Node prev;

    public Node(int data, int cmd, boolean visited, Node next, Node prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedListC {
    Node head;

    public void add(int data, int cmd) {
        if (this.head == null) {
            this.head = new Node(data, cmd, false, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
        } else {
            Node cur = this.head;
            while(cur.next != this.head) {
                cur = cur.next;
            }
            cur.next = new Node(data, cmd,false, cur.next, cur);
            this.head.prev = cur.next;
        }
    }
}

public class Practice3 {
    public static void solution(int[] data) {
        LinkedListC linkedList = new LinkedListC();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i + 1, data[i]);
        }

        Node cur = linkedList.head;

        int visitCnt = 0;
        int cmd = 0;
        while (visitCnt != data.length) {
            int cnt = 0;
            while (cnt != Math.abs(cmd)) {
                if (cmd > 0) {
                    cur = cur.next;
                } else {
                    cur = cur.prev;
                }

                if (cur.visited == false) {
                    cnt++;
                }
            }
            System.out.print(cur.data + " ");
            cur.visited = true;
            visitCnt++;
            cmd = cur.cmd;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
