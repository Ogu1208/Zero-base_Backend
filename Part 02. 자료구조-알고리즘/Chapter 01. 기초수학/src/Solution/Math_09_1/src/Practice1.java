package Solution.Math_09_1.src;

import java.util.ArrayList;

public class Practice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        // ArrayList 의 ArrayList
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    // 하나 위의 행의 좌, 우 데이터 합하기
                    int x = result.get(i - 1).get(j - 1);
                    int y = result.get(i - 1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
