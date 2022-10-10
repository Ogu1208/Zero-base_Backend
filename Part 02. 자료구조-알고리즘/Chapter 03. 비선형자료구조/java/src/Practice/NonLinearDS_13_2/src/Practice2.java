package Practice.NonLinearDS_13_2.src;

import java.util.Arrays;

public class Practice2 {
    public static int[] solution(int[][] intervals, int[] queries) {

        return null;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));
    }
}
