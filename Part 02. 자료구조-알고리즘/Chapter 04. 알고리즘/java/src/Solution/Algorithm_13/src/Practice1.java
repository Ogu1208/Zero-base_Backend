package Solution.Algorithm_13.src;// Practice
// 정수 n 이 주어졌을 때 아래의 연산을 통해 1로 만들려고 한다.
    // 2로 나누어 떨어지면 2로 나누기
    // 3으로 나누어 떨어지면 3으로 나누기
    // 1 빼기
// 위의 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 2
// 출력: 1

// n: 9
// 출력: 2

public class Practice1 {
    public static int solution(int n) {
        // dp 메모리
        int[] dp = new int[n + 1];

        // 각 연산 상황에서의 최소 연산 횟수 업데이트
        for (int i = 2; i <= n; i++) {
            // 빼기 1의 경우
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어 떨어지는 경우 비교
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어 떨어지는 경우 비교
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2));    // 1
        System.out.println(solution(4));    // 2
        System.out.println(solution(6));    // 2
        System.out.println(solution(9));    // 2
        System.out.println(solution(10));   // 3
    }
}
