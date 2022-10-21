package Solution.Algorithm_02_2.src;// 힙 정렬

import java.util.Arrays;

public class Main2 {
    
    // 힙 정렬
    public static void heapSort(int[] arr) {
        // 힙으로 재구성 (maxHeap 기준, 마지막 부모 노드부터)
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // maxHeap 기준 root 쪽을 끝 쪽으로 보내면서 재정렬 -> 오름차순
        for(int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        // 자식 노드 위치
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        // 왼쪽 자식 노드가 크면 maxIdx 를 해당 인덱스로 교체
        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }

        // 오른쪽 자식 노드가 크면 maxIdx 를 해당 인덱스로 교체
        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }

        // maxIdx 가 바뀐 경우, 부모 노드가 교체되는 것을 의미
        // 교체하고 서브 트리 검사 하도록 재귀 호출
        if(parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
