package Solution.Math_09_1.src;

import java.util.HashSet;

public class Practice4 {
    // 수열 반복 특성을 이용해 해결하는 문제
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        // HashSet 에 데이터 추가 성공하면 true 반환, 실패하면 false 반환
        // 반복되는 수열이 등장할 때 false 로 인해 while 문 종료
        while (set.add(n)) {
            int squareSum = 0;
            // 각 자리수 제곱의 합
            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            
            // 1에 도달하면 true 반환
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
