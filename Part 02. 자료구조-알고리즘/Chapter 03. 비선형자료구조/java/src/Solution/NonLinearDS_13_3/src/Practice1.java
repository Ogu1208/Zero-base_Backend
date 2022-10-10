package Solution.NonLinearDS_13_3.src;

public class Practice1 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int[][] normalView;
    static int[][] rgView;

    public static void solution(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return;
        }

        int n = picture.length;
        normalView = new int[n][n];
        rgView = new int[n][n];

        int normalCnt = 0;
        int rgCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 일반 case
                if (normalView[i][j] == 0) {
                    normalCnt++;
                    normalDFS(picture, j, i, picture[i][j], normalCnt);
                }

                // 적록 색약 case
                if (rgView[i][j] == 0) {
                    rgCnt++;
                    rgDFS(picture, j, i, picture[i][j], rgCnt);
                }
            }
        }

        System.out.println("일반: " + normalCnt);
        System.out.println("적록색약: " + rgCnt);
    }

    // 일반 case
    public static void normalDFS(char[][] picture, int x, int y, char color, int cnt) {
        normalView[y][x] = cnt;

        for (int i = 0; i < dirs.length; i++) {
            int xNext = x + dirs[i][0];
            int yNext = y + dirs[i][1];

            // 범위 체크
            if (xNext < 0 || xNext >= normalView.length || yNext < 0 || yNext >= normalView.length) {
                continue;
            }

            // 방문한 곳 패스
            if (normalView[yNext][xNext] != 0) {
                continue;
            }

            // 같은 색인 경우 dfs 진행
            char nextColor = picture[yNext][xNext];
            if (nextColor == color) {
                normalDFS(picture, xNext, yNext, nextColor, cnt);
            }
        }
    }

    // 적록색약 case
    public static void rgDFS(char[][] picture, int x, int y, char color, int cnt) {
        rgView[y][x] = cnt;

        for (int i = 0; i < dirs.length; i++) {
            int xNext = x + dirs[i][0];
            int yNext = y + dirs[i][1];

            if (xNext < 0 || xNext >= picture.length || yNext < 0 || yNext >= picture.length) {
                continue;
            }

            if (rgView[yNext][xNext] != 0) {
                continue;
            }

            char nextColor = picture[yNext][xNext];
            if (nextColor == color || (color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')) {
                rgDFS(picture, xNext, yNext, nextColor, cnt);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] pictures = {{'R', 'R', 'R', 'B', 'B'}, {'G', 'G', 'B', 'B', 'B'}, {'B', 'B', 'B', 'R', 'R'},
                {'B', 'B', 'R', 'R', 'R'}, {'R', 'R', 'R', 'R', 'R'}};
        solution(pictures); // 4 3
    }
}
