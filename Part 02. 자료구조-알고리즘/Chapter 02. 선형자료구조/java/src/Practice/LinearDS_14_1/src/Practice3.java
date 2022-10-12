package Practice.LinearDS_14_1.src;

class Node {
    int data;  // 풍선의 번호
    int cmd;   // 풍선 안의 메모에 적힌 값

    boolean visited; // 터졌는지 체크
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
            while (cur.next != this.head) {  // 가장 끝 노드 찾기
                cur = cur.next;
            }
            cur.next = new Node(data, cmd, false, cur.next, cur);
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

        int visitedCnt = 0;   // 몇개가 터졌는지 count
        int cmd = 0;
        while (visitedCnt != data.length) {
            int cnt = 0;  // 얼마나 이동했는지 count

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
            visitedCnt++;
            cmd = cur.cmd;  // 다음으로 수행할 것(터뜨린 풍선의 cmd)
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
