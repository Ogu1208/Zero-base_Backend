package Solution.Algorithm_05.src;// Practice5
// 정수형 배열 nums 와 정수 m 이 주어졌다.
// nums 에는 양의 정수 값들이 들어 있고, m 은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums 배열을 m 개의 부분 배열로 분리할 때,
// 각 부분 배열의 합중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

// 입출력 예시
// nums: 7, 2, 5, 10, 8
// m: 2
// 출력: 18

// nums: 1, 2, 3, 4, 5
// m: 2
// 출력: 9


public class Practice5 {
    public static int solution(int[] nums, int m) {
        int left = 0;
        int right = 0;
        
        // 발생 가능한 최소, 최대 기준으로 설정 후 이진 탐색
        // left 는 배열 내 가장 큰 수 (하나씩 다 분리 가능해도 단일로 가장 큰 수)
        // right 은 총합 (분리하지 않은 경우 총합)
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        
        // m 은 1이면 분리하지 않는 것이므로 총합 반환
        if (m == 1) {
            return right;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int total = 0;

            // 배열 데이터 하나씩 합해 보면서 mid 보다 크면 분할 횟수 하나씩 늘려줌
            for (int num : nums) {
                total += num;
                if (total > mid) {
                    total = num;    // 분할 후 그 다음 데이터부터 다시 시작
                    cnt++;
                }
            }

            if (cnt <= m) { // 분할 횟수가 m보다 작거나 같으면 right 쪽을 줄임
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));  // 18

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));  // 9

        nums = new int[] {1, 4, 4};
        System.out.println(solution(nums, 3));  // 4
    }
}
