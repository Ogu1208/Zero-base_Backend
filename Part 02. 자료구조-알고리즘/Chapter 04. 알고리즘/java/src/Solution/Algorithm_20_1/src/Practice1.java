package Solution.Algorithm_20_1.src;

import java.util.Arrays;

public class Practice1 {
    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }

        // min, max 기준 잡기
        Arrays.sort(times);
        int left = 0;
        int right = times[times.length - 1] * n;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 해당 mid 시간 내에 몇 명 심사 가능한지 카운트
            int cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }
            
            // 카운트가 n 명 보다 적으면 left 늘려서 진행
            if (cnt < n) {
                left = mid + 1;
            } else {
                // 카운트가 n 보다 크면 right 줄여서 진행
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
