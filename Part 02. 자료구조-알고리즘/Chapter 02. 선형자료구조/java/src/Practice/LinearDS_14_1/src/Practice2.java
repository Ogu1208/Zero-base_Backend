package Practice.LinearDS_14_1.src;

import java.util.ArrayList;

public class Practice2 {

    public static void solution(int[][] matrix) {
        boolean frZero = false;
        boolean fcZero = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {  // 첫째 줄이었을 경우(1행)
                        frZero = true;
                    }

                    if (j == 0) {  // 첫째 열이었을 경우
                        fcZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][i] = 0;
                }

            }
        }

        // 안쪽부터 각각의 원소들을 비교해 0으로 채움
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (frZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (fcZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
