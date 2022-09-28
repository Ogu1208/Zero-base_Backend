package Practice.Math_09_1.src;

public class Practice5 {
    public static int solution(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};  // 하 우 좌 위
        int cnt = 0;  // 총 변의 길이

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {  // 땅일 경우 4면 체크
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        // (x < 0 || y < 0 || x >= row || y >= col) 인 경우는 가장자리가 변인 경우
                        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) { // 끝에 맞닿아 있는 지역이거나 물일 경우
                            cnt++;
                        }
                    }

                }
            }
        }
        return cnt;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};  // 하 우 좌 위

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, directions, i, j);
                }
            }
        }
        return 0;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = -1;
        int cnt = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) { // 끝에 맞닿아 있는 지역이거나 물일 경우
                cnt++;
            } else {
                if (grid[x][y] == 1) {   // 땅일 경우
                    cnt += recursion(grid, directions, x, y);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
