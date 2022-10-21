package Solution.Algorithm_12.src;// 알고리즘 - 다이나믹 프로그래밍

public class Main {
    // 피보나치 수열 (일반 풀이 - O(n^2))
    // 계산했던 부분도 다시 계산
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 피보나치 수열 (DP 풀이 - 타뷸레이션 - O(n))
    public static int fibDP(int n) {
        // DP 용 메모리 필요
        int[] dp = new int[n < 2 ? 2 : n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 저장한 값 기반으로 피보나치 수열 계산
        // 테이블을 채워나가는 방식
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    // 피보나치 수열 (DP 풀이 - 메모이제이션)
    static int[] dp = new int[8];
    public static int fibDP2(int n) {
        if (n <= 2) {
            return 1;
        }

        // 기록해둔 게 있으면 사용
        if (dp[n] != 0) {
            return dp[n];
        }

        // 없으면 하위 호출
        dp[n] = fibDP2(n - 1) + fibDP2(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}
