package Solution.NonLinearDS_13_1.src;

public class Practice2 {
    public static void solution(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        // 외곽 부에서 시작해서 연결된 지점들에 대해 표시
        // 좌우 외곽 부
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }

        // 상하 외곽 부
        for (int j = 1; j < col - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfs(board, row - 1, j);
            }
        }

        // 표시 후 O 그대로 남아 있으면 X 로 변경
        // *로 방문 되었으면 O 로 유지
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y) {
        // 범위를 넘어서는 경우 return
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return;
        }

        // O 가 아니면 return
        if (board[x][y] != 'O') {
            return;
        }

        // O로 dfs 타고 들어오는 부분들은 방문 표식
        board[x][y] = '*';
        dfs(board, x + 1, y);   // 우
        dfs(board, x - 1, y);   // 좌
        dfs(board, x, y + 1);   // 하
        dfs(board, x, y - 1);   // 상
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
