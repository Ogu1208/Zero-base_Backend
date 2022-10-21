package Solution.Algorithm_05.src;// Practice
// 원형 정렬 상태 배열에서의 이진 탐색
// nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
// 이진 탐색으로 데이터를 찾는 프로그램을 작성하세요.
// O(log n) 유지
// 배열을 재 정렬하지 않고 풀기

// 입출력 예시
// arr: 4, 5, 6, 7, 8, 0, 1, 2

// target: 0
// 출력: 5

// target: 3
// 출력: -1

public class Practice2 {
    public static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            // O(logN)으로 해결해야 하기 때문에
            // 기존의 이진 탐색과 같은 구조로 접근
            
            // left 가 중간보다 작은 상태인지 확인
            // 4, 5, 6, 7, 0, 1, 2 와 같은 배열 상태
            if (arr[left] <= arr[mid]) {
                // 원형 정렬 상태 배열이기 때문에 left 위치 값 보다 큰지도 체크
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 11, 5, 6, 7, 8, 9, 10 과 같은 배열 상태
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));  // 5
        System.out.println(solution(nums, 3));  // -1
    }
}
