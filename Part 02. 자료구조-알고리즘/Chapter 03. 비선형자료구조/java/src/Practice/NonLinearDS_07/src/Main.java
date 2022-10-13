package Practice.NonLinearDS_07.src;// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);  // index가 1번부터 시작할 수 있도록
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;  // 방금 넣은 데이터
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }
        int target = heap.get(1); // 가장 상위 데이터

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1; // 최상위
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {  // 자식 노드가 하나인 경우
                targetIdx = cur * 2;
            } else { // 자식 노드가 없는 경우, leaf인경우
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {  // 더이상 바꾸지 않아도 되는 경우
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }


    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();
//
//        System.out.println();
//        System.out.println("== 데이터 삭제 ==");
//        System.out.println("삭제: " + minHeap.delete());
//        minHeap.printTree();
//        System.out.println("삭제: " + minHeap.delete());
//        minHeap.printTree();
//        System.out.println("삭제: " + minHeap.delete());
//        minHeap.printTree();
    }
}
