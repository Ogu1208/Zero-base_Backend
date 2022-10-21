package Solution.Algorithm_09.src;// Practice
// 양의 정수 n 이 주어지고 다음의 연산을 수행할 수 있을 때,
//    1. n 이 짝수인 경우, 2로 나누기 연산
//    2. n 이 홀수일 때는 1 을 더하거나 1을 빼는 연산
// 주어진 n 이 1 이 되는데 필요한 최소한의 연산 횟수를 반환하세요.

// 입출력 예시
// n: 8
// 출력: 3

// n: 7
// 출력: 4

// n: 9
// 출력: 4

public class Practice3 {
    public static int solution(int n) {
        // 0 이나 1  이면 더하기 또는 나누기 연산 1회
        if (n == 0 || n == 2) {
            return 1;
        }

        // 1 이면 연산 필요 없음
        if (n == 1) {
            return 0;
        }

        int cnt = 0;
        while (n != 1) {
            // 3 인 경우는 3 -> 2 -> 1 로 2 더해주고 break
            if (n == 3) {
                cnt += 2;
                break;
            }

            // 짝수인 경우 나누기 2
            // 홀수일 때는 4의 배수가 되는 쪽으로 증감
            if (n % 2 == 0) {
                n /= 2;
            } else if ((n + 1) % 4 == 0) {
                n = n + 1;
            } else if ((n - 1) % 4 == 0) {
                n = n - 1;
            }
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(8));    // 3
        System.out.println(solution(7));    // 4
        System.out.println(solution(9));    // 4
        System.out.println(solution(6));    // 3
    }
}
