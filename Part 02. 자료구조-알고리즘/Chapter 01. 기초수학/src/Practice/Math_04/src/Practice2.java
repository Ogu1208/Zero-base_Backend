package Practice.Math_04.src;// Practice2
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 방법 2

import java.util.Arrays;

public class Practice2 {
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {

    }

    public static void main(String[] args) {
//      Test code
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[4];

        Practice2 p = new Practice2();
        p.permutation(arr, 0, n, r, visited, out);
    }
}
