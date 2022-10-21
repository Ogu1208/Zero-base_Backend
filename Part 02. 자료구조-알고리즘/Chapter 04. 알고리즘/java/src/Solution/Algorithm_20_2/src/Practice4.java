package Solution.Algorithm_20_2.src;

public class Practice4 {
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int maxVal = 0;
        // 정사각형 구하므로 위 아래로 인접한 두 줄만 있으면 가능하므로 2행 x 열 길이 만큼만 dp 테이블 생성
        int[][] dp = new int[2][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i % 2][j] = matrix[i][j];
                // 첫 행, 첫 열이 아니고 현재 위치가 0 이 아닐 때
                if (i != 0 && j != 0 && dp[i % 2][j] != 0) {
                    int up = dp[i % 2][j - 1];
                    int left = dp[(i - 1) % 2][j];
                    int ul = dp[(i - 1) % 2][j - 1];

                    // 인접한 정사각 형 구역 중 최소 값 구해서 1 증가
                    int minVal = Math.min(Math.min(up, left), ul);
                    dp[i % 2][j] = minVal + 1;
                }
                maxVal = Math.max(maxVal, dp[i % 2][j]);
            }
        }

        return maxVal * maxVal;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{0, 1}, {1, 0}};
        System.out.println(solution(data));

        data = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 0}};
        System.out.println(solution(data));
    }
}
