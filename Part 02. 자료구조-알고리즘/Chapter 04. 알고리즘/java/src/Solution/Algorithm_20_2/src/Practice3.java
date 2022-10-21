package Solution.Algorithm_20_2.src;

import java.util.Arrays;

public class Practice3 {
    public static int solution(int[] weights) {
        // 우선 무게 순으로 오름차순 정렬
        Arrays.sort(weights);

        int cur = 0;
        for (int i = 0; i < weights.length; i++) {
            // 현재 무게 + 1이 그 다음 저울 추의 무게보다 작을 때 더 이상 측정 불가
            if (cur + 1 < weights[i]) {
                break;
            }
            cur += weights[i];
        }

        return cur + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {6, 1, 2, 3, 1, 7, 30};
        System.out.println(solution(weights));
    }
}
