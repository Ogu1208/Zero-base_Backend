package Solution.NonLinearDS_08.src;// Practice 1
// 최소 힙에서 특정 값을 변경하는 코드를 작성하세요.
// 특정 값이 여러개라면 모두 바꿔주세요.

import java.util.ArrayList;

class MinHeap{
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        // 가장 끝 위치에 데이터 추가
        heap.add(data);

        // 추가한 후 부모와 크기 비교하며 자기 자리 찾아가기
        int cur = heap.size() - 1;
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

        // delete 대상 노드는 가장 상위 노드
        int target = heap.get(1);

        // 마지막 노드를 가장 위로 설정 후 마지막 노드는 삭제
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) { // 자식 노드 둘다 있는 경우
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) { // 왼쪽 자식 노드만 있는 경우
                targetIdx = cur * 2;
            } else {
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {  // 부모가 작으면 종료
                break;
            } else {    // 부모가 더 크면 자리 바꾸기
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

public class Practice1 {
    public static void solution(MinHeap minHeap, int from, int to) {
        
        for (int i = 1; i < minHeap.heap.size(); i++) {
            if (minHeap.heap.get(i) == from) {  // 변경할 값 발견
                minHeap.heap.set(i, to);        // 값 변경

                moveUp(minHeap, i);
                moveDown(minHeap, i);
            }
        }
        
    }

    public static void moveUp(MinHeap minHeap, int idx) {
        int cur = idx;
        while (cur > 1 && minHeap.heap.get(cur / 2) > minHeap.heap.get(cur)) {
            int parentVal = minHeap.heap.get(cur / 2);
            minHeap.heap.set(cur / 2, minHeap.heap.get(cur));
            minHeap.heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public static void moveDown(MinHeap minHeap, int idx) {
        int cur = idx;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < minHeap.heap.size()) { // 자식 노드 둘다 있는 경우
                targetIdx = minHeap.heap.get(leftIdx) < minHeap.heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < minHeap.heap.size()) { // 왼쪽 자식 노드만 있는 경우
                targetIdx = cur * 2;
            } else {
                break;
            }

            if (minHeap.heap.get(cur) < minHeap.heap.get(targetIdx)) {  // 부모가 작으면 종료
                break;
            } else {    // 부모가 더 크면 자리 바꾸기
                int parentVal = minHeap.heap.get(cur);
                minHeap.heap.set(cur, minHeap.heap.get(targetIdx));
                minHeap.heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap, 60, 1);
        minHeap.printTree();
    }
}
