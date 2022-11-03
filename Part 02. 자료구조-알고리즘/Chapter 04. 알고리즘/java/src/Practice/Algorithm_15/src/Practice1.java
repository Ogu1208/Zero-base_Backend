package Practice.Algorithm_15.src;// Practice1
// 정수형 n과 m이 주어졌을 때,
// 1 부터 n 까지의 정수 중에서 중복 없이 m 개를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 3
// m: 2
// 출력: [1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]

import java.util.Arrays;

public class Practice1 {

    public static boolean[] visited;
    public static int[] out;

    public static void solution(int n, int m) {
        visited = new boolean[n];
        out = new int[m];
        permutation(n, m, 0);

    }

    public static void permutation(int n, int m, int depth) {
        if (depth == m) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = i + 1;
                permutation(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 2);
        System.out.println();
        solution(4, 3);
    }
}
