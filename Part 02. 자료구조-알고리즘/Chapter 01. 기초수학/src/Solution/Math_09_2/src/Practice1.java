package Solution.Math_09_2.src;

public class Practice1 {

    public static int solution(int n) {
        int result = 0;

        // 0항과 1항은 1
        if (n <= 1) {
            return 1;
        }

        // 점화식에 따른 재귀함수 구성
        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(n - i - 1);
        }
        return result;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
