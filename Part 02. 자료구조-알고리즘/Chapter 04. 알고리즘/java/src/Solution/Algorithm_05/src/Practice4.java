package Solution.Algorithm_05.src;// Practice4
// 정수형 배열 weights 와 정수 days 가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days 는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
// days: 5
// 출력: 15

// weights: 3, 2, 2, 4, 1, 4
// days: 3
// 출력: 6


public class Practice4 {
    public static int solution(int[] weights, int days) {
        int left = 0;
        int right = 0;

        // 이 무게 배열 그대로 이진 탐색 사용은 할수 없고,
        // left 에는 배열 내 가장 무거운 무게 (최소한의 적재량)
        // right 는 무게 총합 (최대한의 적재량)
        // 으로 두고 이 사이에서 이진 탐색 진행
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int cur = 0;

            // 무게 배열 순으로 적재해 보면서 현재 mid 적재량을 넘을 때마다 cnt 증가 (필요 일 수)
            for (int w : weights) {
                if (cur + w > mid) {
                    cnt += 1;
                    cur = 0;
                }
                cur += w;
            }

            // 필요 일 수가 days 보다 크면 더 큰 적재량의 차량이 필요
            if (cnt > days) {
                left = mid + 1;
            } else {    // 필요 일 수가 days 보다 작으면 좀더 적은 적재량의 차량도 가능
                right = mid - 1;
            }
        }
        // 최종 적재량 반환
        return left;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
