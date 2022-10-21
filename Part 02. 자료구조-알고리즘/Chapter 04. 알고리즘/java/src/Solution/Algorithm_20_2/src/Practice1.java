package Solution.Algorithm_20_2.src;

import java.util.Arrays;

public class Practice1 {
    public static int solution(int[] rocks, int goal, int n) {
        if (rocks == null || rocks.length == 0) {
            return -1;
        }

        Arrays.sort(rocks);

        // 바위를 n 개 지웠을 때 최소 step 중 max 값을 찾는 문제
        int left = 0;
        int right = goal;

        int result = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;
            
            // mid 간격 보다 돌 사이 간격이 작으면 제거
            // 그렇지 않으면 pass
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
                if (cnt > n) {
                    break;
                }
            }
            // 최종 위치와의 간격도 계산
            if (goal - prev < mid && cnt <= n) {
                cnt++;
            }

            // n 개 보다 많이 제거 했으면, 간격을 줄여서 반복
            // n 개 보다 적게 재거 했으면, 간격을 늘려서 반복
            if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;

                if (cnt == n) {
                    result = Math.max(result, mid);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }
}
