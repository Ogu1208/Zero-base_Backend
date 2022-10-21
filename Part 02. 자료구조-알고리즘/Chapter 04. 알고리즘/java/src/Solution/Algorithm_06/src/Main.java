package Solution.Algorithm_06.src;// 알고리즘 - 투 포인터
// for-loop vs two pointers

import java.util.Arrays;

public class Main {
    public static int[] forLoop(int[] arr, int target) {
        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (sum == target) {
                    result[0] = i;
                    result[1] = j - 1;
                    break;
                }
                sum += arr[j];
            }

            if (sum == target) {
                break;
            }
        }

        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] result = {-1, -1};
        
        while (true) {
            // 합계가 target 보다 크면 p1 포인터 이동
            if (sum > target) {
                sum -= arr[p1++];
            } else if (p2 == arr.length){
                // 합계가 target 보다 크지 않은 상황에서 p2 이 끝에 도달했으면 해당 구간 없음
                break;
            } else {
                // 합계가 target 보다 작으면 p2 포인터 이동
                sum += arr[p2++];
            }
            
            // 합계가 target 과 같을 때 해당 구간 업데이트 후 반환
            if (sum == target) {
                result[0] = p1;
                result[1] = p2 - 1;
                break;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
    }
}
