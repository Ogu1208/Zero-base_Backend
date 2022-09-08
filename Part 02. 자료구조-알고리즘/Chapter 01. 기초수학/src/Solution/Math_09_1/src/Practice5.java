package Solution.Math_09_1.src;

public class Practice5 {
    public static int solution(int[][] grid) {
        // 이동 방향
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int cnt = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // 땅일 때 각 방향 탐색
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        // 최외곽 부분에 닿을 때와 물의 영역에 닿을 때 둘레 카운트 늘려줌
                        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
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
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 땅인 경우 각 방향 탐색을 재귀호출로 수행
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
        
        // 재방문에 의한 중복 계산을 하지 않게 설정
        grid[i][j] = -1;
        int cnt = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
                cnt++;
            } else {
                // 재귀 호출
                if (grid[x][y] == 1) {
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
