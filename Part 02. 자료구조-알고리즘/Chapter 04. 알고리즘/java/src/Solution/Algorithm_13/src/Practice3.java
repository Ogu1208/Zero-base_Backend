package Solution.Algorithm_13.src;// Practice
// 배낭에 물품을 담으려고 한다.
// 배낭에는 k 무게 만큼의 물품을 담을 수 있다.
// n 개의 물품이 주어지고 이 물품의 무게와 가치 정보가 items 2차원 배열에 주어졌을 때,
// 최대 가치가 되도록 물품을 담았을 때의 가치를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// items: {{6, 13}, {4, 8}, {3, 6}, {5, 12}}
// n: 4
// k: 7
// 출력: 14


public class Practice3 {

    public static int solution(int[][] items, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // n 개의 물품에 대해 모든 경우의 수 dp 진행
        for (int i = 0; i < n; i++) {
            // 무게 1 ~ k 상황에 대한 계산
            for (int j = 1; j <= k; j++) {
                // 물품을 넣을 수 없을 때는 그 이전의 기록된 가치 가져옴
                if (items[i][0] > j) {
                    dp[i + 1][j] = dp[i][j];
                }
                // 물품을 넣을 수 있는 경우,
                // 이전의 기록된 가치와 현재 담을 수 있는 물품의 가치 비교하여 큰 값으로 업데이트
                else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - items[i][0]] + items[i][1]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Test code
        int[][] items = {{6, 13}, {4, 8}, {3, 6}, {5, 12}};
        System.out.println(solution(items, 4, 7));  // 14
    }
}
