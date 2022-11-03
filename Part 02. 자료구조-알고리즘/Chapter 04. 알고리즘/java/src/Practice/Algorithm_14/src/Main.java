package Practice.Algorithm_14.src;// 알고리즘 - 백트래킹

public class Main {

    static int n = 4;
    static int[] board = new int[n];
    static int cnt;
    public static int nQueen(int row) {
        if(row == n) {  // 모든 퀸을 놓았을 때
            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;  // row 행 i번쨰 열에 놓는다

            // promising (유망한지)
            if(isPromising(row)) {
                nQueen(row + 1);
            }

        }

        return cnt;
    }

    public static boolean isPromising(int row) {  // 현재 퀸을 놓은 행까지 검사
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                // 같은 열에 있으면 안되고, 대각선 체크
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
