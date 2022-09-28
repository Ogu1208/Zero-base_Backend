package Practice.LinearDS_11.src;// Practice3
// 데크 리사이즈
// 기본 데크 구조에서 데크 공간이 full 일 때 데이터를 추가하는 경우,
// 데크 공간을 2배 씩 늘려주는 코드를 작성하세요.

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size) {
        this.arr = new int[size + 1];
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1)  % this.arr.length == this.front;
    }

    public void increaseSize() {

    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        this.arr[front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data) {
        if (this.isFull()) {
            System.out.println("Deque is full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyDeque2 myDeque = new MyDeque2(5);

        myDeque.addLast(1);
        myDeque.addLast(2);
        myDeque.addLast(3);
        myDeque.addLast(4);
        myDeque.addLast(5);
        myDeque.printDeque();

        myDeque.addLast(6);
        myDeque.addLast(7);
        myDeque.addLast(8);
        myDeque.addLast(9);
        myDeque.addLast(10);
        myDeque.printDeque();

        myDeque.removeLast();
        myDeque.removeLast();
        myDeque.addFirst(100);
        myDeque.addFirst(200);
        myDeque.printDeque();

        myDeque.addFirst(300);
        myDeque.addFirst(400);
        myDeque.addFirst(500);
        myDeque.printDeque();
    }
}
