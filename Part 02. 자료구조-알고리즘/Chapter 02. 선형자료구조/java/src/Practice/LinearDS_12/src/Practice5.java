package Practice.LinearDS_12.src;// Practice5
// 해시 충돌 해결 - 분리 연결법

class Node {
    int data;
    Node next;

    Node() {}
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {}
    LinkedList(Node node) {
        this.head = node;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist!");
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class MyHashTable5 {
}

public class Practice5 {
    public static void main(String[] args) {
        // Test code
//        MyHashTable5 ht = new MyHashTable5(11);
//        ht.setValue(1, 10);
//        ht.setValue(2, 20);
//        ht.setValue(3, 30);
//        ht.printHashTable();
//        ht.setValue(12, 11);
//        ht.setValue(23, 12);
//        ht.setValue(34, 13);
//
//        ht.setValue(13, 21);
//        ht.setValue(24, 22);
//        ht.setValue(35, 23);
//
//        ht.setValue(5, 1);
//        ht.setValue(16, 2);
//        ht.setValue(27, 3);
//        ht.printHashTable();
//
//        System.out.println("== key 값으로 해당 데이터 가져오기 ==");
//        System.out.println(ht.getValue(1));
//        System.out.println(ht.getValue(12));
//
//        System.out.println("== 데이터 삭제 ==");
//        ht.removeValue(1);
//        ht.removeValue(5);
//        ht.removeValue(16);
//        ht.printHashTable();

    }
}
