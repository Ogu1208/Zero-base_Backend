package Solution.NonLinearDS_13_1.src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {
    public static int solution(int[] forbidden, int a, int b, int x) {
        int cnt = 0;
        // 순방향 상한선용 변수 초기화
        int limit = x + a + b;


        Queue<int[]> queue = new LinkedList();
        // 초기 {방향, 위치} 큐에 추가
        queue.offer(new int[]{0, 0});

        // forbidden visited 에 업데이트
        HashSet<int[]> visited = new HashSet<>(queue);
        for (int pos : forbidden) {
            visited.add(new int[]{0, pos});
            visited.add(new int[]{1, pos});
            // limit 업데이트
            // a >= b 인 경우, 목적지 x 를 넘어가면 되돌아올 수 없음
            // a < b 인 경우, 되돌아 오는게 가능한데 forbidden 에 걸리면 안됨
            // 따라서 기본 limit 을 forbidden 중 max + a + b 로 설정
            limit = Math.max(limit, pos + a + b);
        }

        // 큐 빌 때 까지 이동 반복
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] cur = queue.poll();
                int dir = cur[0];
                int pos = cur[1];

                // 목적지 에 도달 시 반환
                if (pos == x) {
                    return cnt;
                }

                // forward 방향 추가
                int[] forward = new int[]{0, pos + a};
                if (pos + a <= limit && visited.add(forward)) {
                    queue.offer(forward);
                }

                // backward 방향 추가
                int[] backward = new int[]{1, pos - b};
                if (dir == 0 && pos - b >= 0 && visited.add(backward)) {
                    queue.offer(backward);
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));
    }
}
