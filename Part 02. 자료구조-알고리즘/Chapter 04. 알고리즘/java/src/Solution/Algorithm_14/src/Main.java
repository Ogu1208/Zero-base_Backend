package Solution.Algorithm_14.src;// 알고리즘 - 백트래킹

public class Main {
    static int n = 4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row) {
        // 정상적으로 다 놓은 경우
        if (row == n) {
            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }

        // 각 행 각 열에 퀸을 놓으면서 가능성 검사
        for (int i = 0; i < n; i++) {
            // row 행에 i 열에 퀸 위치시킴 (1차원 배열로 열의 번호를 기록)
            board[row] = i;

            // 유망성 체크
            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }
        return cnt;
    }

    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 놓은 경우 false
            // 대각선에 있는 경우 false
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}
