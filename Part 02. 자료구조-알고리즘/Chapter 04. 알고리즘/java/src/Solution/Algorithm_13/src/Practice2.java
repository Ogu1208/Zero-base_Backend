package Solution.Algorithm_13.src;// Practice
// 수열 arr 이 주어졌을 때,
// 부분 수열 중 증가하는 부분이 가장 긴 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// arr: {10, 20, 30, 10, 50, 10}
// 출력: 4

public class Practice2 {
    public static int solution(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        int result = 0;
        for (int i = 1; i <= n; i++) {
            // 우선 현재 위치에서의 부분 수열 길이 1로 두고 증가하는 경우 업데이트
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                // 증가하는 부분 수열 case 에서의 dp 업데이트
                if (arr[j - 1] < arr[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = new int[]{10, 20, 30, 10, 50, 10};
        System.out.println(solution(arr));
    }
}
