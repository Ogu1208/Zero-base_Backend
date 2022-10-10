package Solution.NonLinearDS_13_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    public static int solution(int[][] times, int targetFriend) {
        // 힙 두개 사용
        // 1. 이용 가능한 좌석 관리 (좌석번호 기준 min heap)
        // 2. 도착한 친구에 대한 관리 (떠나는 시간 기준 min heap)

        // 대상 친구의 도착시간 변수
        int targetArrival = times[targetFriend][0];

        // 도착 시간 기준 오름차순 정렬
        Arrays.sort(times, (x, y) -> x[0] - y[0]);

        // 의자 번호 기준 min heap 구성
        PriorityQueue<Integer> pqChair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pqChair.offer(i);
        }

        // 떠나는 시간 기준 min heap 구성
        PriorityQueue<int[]> pqFriend = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int i = 0; i < times.length; i++) {
            // i 번째 친구의 도착 시간보다 먼저 떠나는 친구들에 대해
            // pqFriend 에서 제외 후 pqChair 쪽에 추가
            while (!pqFriend.isEmpty() && pqFriend.peek()[0] <= times[i][0]) {
                pqChair.offer(pqFriend.poll()[1]);
            }

            // i 의 도착시간이 대상 친구의 도착시간과 같은 경우 break
            if (times[i][0] == targetArrival) {
                break;
            }

            // i 번째 친구의 떠나는 시간과 빈 자리 할당하여 pqFriend 에 추가
            pqFriend.offer(new int[]{times[i][1], pqChair.poll()});
        }

        return pqChair.peek();
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2
    }
}
