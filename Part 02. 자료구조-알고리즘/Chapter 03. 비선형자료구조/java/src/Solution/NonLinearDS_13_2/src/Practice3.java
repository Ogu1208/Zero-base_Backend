package Solution.NonLinearDS_13_2.src;

import java.util.PriorityQueue;

public class Practice3 {
    public static boolean solution(int[] target) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        int sum = 0;
        for (int num : target) {
            sum += num;
            pq.add(num);
        }

        while (pq.peek() != 1) {
            // 큰 값부터 꺼내서 sum 에서 차감
            int num = pq.poll();
            sum -= num;

            // 차감한 후의 sum 보다 num 이 작거나 sum 이 1보다 작으면 false
            if (num <= sum || sum < 1) {
                return false;
            }

            // 다음 값 비교를 위해 업데이트
            num -= sum;
            sum += num;
            pq.add(num > 0 ? num : sum);
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
