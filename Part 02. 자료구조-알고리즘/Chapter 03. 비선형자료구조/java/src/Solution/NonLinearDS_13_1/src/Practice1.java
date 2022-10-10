package Solution.NonLinearDS_13_1.src;

public class Practice1 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean solution(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word) {
        int row = board.length;
        int col = board[0].length;
        // dfs 로 끝까지 도달했으면 true
        if (i == word.length()) {
            return true;
        }

        // 범위를 넘어서는 경우 false
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }

        // 이미 방문했으면 false
        if (visited[x][y]) {
            return false;
        }

        // 해당 문자가 같지 않은 경우 false
        if (board[x][y] != word.charAt(i)) {
            return false;
        }
        
        // 방문 표시
        visited[x][y] = true;
        // 각 방향에 대해 순회 진행
        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];
            // 그 다음 dfs, i + 1 로 다음 문자 확인
            if (dfs(board, visited, xNext, yNext, i + 1, word)) {
                return true;
            }
        }
        // 해당 방향으로의 단어 일치하지 않은 경우 false 로 바꿔 준뒤 false 반환
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}
