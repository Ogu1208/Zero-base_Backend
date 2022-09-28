package Practice.Math_09_1.src;

import java.util.Arrays;

public class Practice2 {
    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {  // 좌측에 더 큰 수가 있는지 찾는다.
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {  // 정렬이 이미 되어있는경우
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {  // 연속해서 같은수라면 안쪽값과 바꿔야 더 큰수 반환
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

        arr = new int[]{5, 4, 3, 4, 5};
        solution(arr);
    }
}
