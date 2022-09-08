package Solution.Math_09_2.src;

public class Practice4 {
    // 문제에서 overflow 방지 용으로 주어진 수
    final static int mod = (int) 1e9 + 7;

    public static int solution(long n) {
        // 5c1 * 4c1 * 5c1 * 4c1 * ...
        // 5c1 자리 만큼 * 4c1 자리 만큼 재귀로 계산
        return (int) (recursion(5, (n + 1) / 2) * recursion(4, n / 2) % mod);
    }

    public static long recursion(long x, long y) {
        if (y == 0) {
            return 1;
        }

        long p = recursion(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % mod;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));
    }
}
