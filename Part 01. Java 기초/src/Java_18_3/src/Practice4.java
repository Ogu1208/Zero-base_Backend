package Java_18_3.src;

import java.util.ArrayList;

public class Practice4 {
    public static ArrayList<Integer> solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) { // 첫줄 오른쪽 방향
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {   // colEnd 오른쪽 아랫방향
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {  // 마지막줄 왼쪽방향
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {   // 왼쪽 위로 올라가는 방향
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println((solution(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println((solution(matrix)));
    }
}
