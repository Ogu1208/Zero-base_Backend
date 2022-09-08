package Solution.Math_09_1.src;

import java.util.Arrays;

public class Practice2 {
    public static void solution(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        // 현재 데이터의 정렬 상태 확인
        // swap 필요 index 세팅
        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        // idx 가 -1 이면 기 정렬 상태
        if (idx == -1) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        // 바꿀 자리 찾아서 swap
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
