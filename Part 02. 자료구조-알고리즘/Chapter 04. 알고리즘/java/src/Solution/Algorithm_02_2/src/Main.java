package Solution.Algorithm_02_2.src;// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;

public class Main {
    
    // 합병 정렬
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;
        // p, q 둘 중 하나는 해당 배열 범위 안에 있는 동안
        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {   // 둘 다 범위 안인 경우
                if (arr[p] <= arr[q]) { // 값 비교하여 정렬
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) { // 왼쪽만 남은 경우 이어주기
                tmp[idx++] = arr[p++];
            } else {                            // 오른쪽만 남은 경우 이어주기
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = left; i <= right; i++) {   // 정렬된 부분 데이터 arr 쪽으로
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
