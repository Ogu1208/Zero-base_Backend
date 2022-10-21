package Practice.Algorithm_20_1.src;

public class Practice5 {

    public static int solution(int n, int m, int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int m = 5;
        int[][] data = {{1, 2, 0}, {1, 4, 0}, {2, 3, 0}, {3, 4, 1}, {4, 2, 1}};

        System.out.println(solution(n, m, data));
    }
}
