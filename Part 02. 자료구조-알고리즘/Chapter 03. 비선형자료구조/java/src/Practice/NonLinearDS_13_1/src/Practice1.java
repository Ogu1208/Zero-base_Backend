package Practice.NonLinearDS_13_1.src;

public class Practice1 {

    public static boolean solution(char[][] board, String word) {

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
