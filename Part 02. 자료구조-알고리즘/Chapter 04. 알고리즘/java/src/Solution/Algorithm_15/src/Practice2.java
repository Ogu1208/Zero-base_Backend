package Solution.Algorithm_15.src;// Practice2
// 숫자 7193 은 7193 도 소수이고,
// 719, 71, 7 도 각각 소수이다.
// n 이 주어졌을 때, n 자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.

// 입출력 예시
// 입력 n: 3
// 출력: 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797


import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        // 한 자리의 소수부터 시작
        int[] primeNum = {2, 3, 5, 7};
        for (int i = 0; i < primeNum.length; i++) {
            backTracking(primeNum[i], 1, n);
        }

        return result;
    }

    public static void backTracking(int prime, int len, int n) {
        if (len >= n) {
            result.add(prime);
            return;
        }

        // 첫 째 자리 소수 뒤에 숫자 붙여서 반복 진행
        // 이 때 0, 2, 4, 5, 6, 8 가 뒤에 붙으면 소수가 되지 않으므로 해당 방향으로 더이상 진행하지 않음
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0 || i != 5) {
                int primeCandidate = prime * 10 + i;
                if (isPrimeNum(primeCandidate)) {
                    backTracking(primeCandidate, len + 1, n);
                }
            }
        }
    }

    public static boolean isPrimeNum(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
