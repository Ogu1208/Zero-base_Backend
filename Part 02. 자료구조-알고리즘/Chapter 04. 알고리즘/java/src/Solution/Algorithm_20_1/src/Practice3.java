package Solution.Algorithm_20_1.src;

import java.util.ArrayList;

public class Practice3 {

    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        boolean[] used = new boolean[items.length + 1];

        // 초기 사용 상태 업데이트
        int idx = 0;
        int cnt = 0;
        while (cnt < n) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }

        int result = 0;
        while (idx < items.length) {
            // 이번에 사용하려는 전기용품이 연결되어 있지 않은 경우
            if (!used[items[idx]]) {
                // 현재 콘센트에 연결된 용품 중 나중에 다시 사용하게 될 용품은 list 에 추가
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) {
                        list.add(items[i]);
                    }
                }

                // 콘센트에 연결된 용품 모두 나중에 다시 사용하는 경우 순서상 나중에 사용할 용품 먼저 빼기
                if (list.size() == n) {
                    used[list.get(n - 1)] = false;
                } else {
                    // 그 외에는 앞으로 사용하지 않는 용품 1개 빼기
                    for (int j = 1; j <= items.length; j++) {
                        if (used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }

                // 새롭게 연결할 item 업데이트
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
