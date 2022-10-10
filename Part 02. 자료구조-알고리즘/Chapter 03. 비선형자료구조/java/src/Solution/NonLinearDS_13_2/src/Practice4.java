package Solution.NonLinearDS_13_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice4 {
    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        // 작업자 데이터 구성 {효율, 속도}
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        // 효율 기준 내림차순 정렬
        Arrays.sort(engineers, (x, y) -> y[0] - x[0]);

        // 속도 기준 min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (x, y) -> x - y);
        int sum = 0;
        int result = 0;
        
        // 작업자 속도 pq 에 추가
        for (int[] eg : engineers) {
            pq.add(eg[1]);
            sum += eg[1];

            // 작업자 수가 k 를 넘으면 속도가 낮은 기준으로 한명 제외
            if (pq.size() > k) {
                sum -= pq.poll();
            }

            // 작업자 둘의 속도합 * 효율 (효율은 내림차순 정렬이므로 낮은 쪽 기준으로 업데이트 됨)
            result = Math.max(result, (sum * eg[0]));
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
