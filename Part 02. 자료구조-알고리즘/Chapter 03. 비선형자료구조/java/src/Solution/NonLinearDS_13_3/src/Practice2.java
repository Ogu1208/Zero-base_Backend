package Solution.NonLinearDS_13_3.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static class room {
        int x;
        int y;

        public room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int n, int[][] switches) {
        if (switches == null || switches.length == 0 || switches[0].length == 0) {
            return -1;
        }

        // 그래프 구성
        ArrayList<room>[][] graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < switches.length; i++) {
            graph[switches[i][0] - 1][switches[i][1] - 1].add(new room(switches[i][2] - 1, switches[i][3] - 1));
        }

        // 방의 불 켜진 상태 변수
        boolean[][] switched = new boolean[n][n];
        switched[0][0] = true;

        int cnt = bfs(n, graph, switched);
        return cnt + 1;
    }

    public static int bfs(int n, ArrayList<room>[][] graph, boolean[][] switched) {
        // bfs 큐 준비
        Queue<room> queue = new LinkedList();
        queue.offer(new room(0, 0));

        // 방문 체크 변수
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // 불 켠 횟수 카운트
        int cnt = 0;
        while (!queue.isEmpty()) {
            room cur = queue.poll();

            // 인접 노드 방문
            for (room r : graph[cur.x][cur.y]) {
                // 방에 불이 꺼져 있는 경우 켜고 카운트 증가
                if (!switched[r.x][r.y]) {
                    switched[r.x][r.y] = true;
                    cnt++;
                }
            }

            // 인접한 방 이동 가능한지 체크
            for (int[] dir : dirs) {
                int xNext = cur.x + dir[0];
                int yNext = cur.y + dir[1];

                // 방의 범위 안에 있는지 확인
                if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
                    // 불이 켜져 있고 방문한 적 없으면 큐에 추가
                    if (switched[xNext][yNext] && !visited[xNext][yNext]) {
                        queue.offer(new room(xNext, yNext));
                        visited[xNext][yNext] = true;
                    }
                }
            }
        }

        // 불 한번이라도 켠 경우 다시 bfs 진행
        return cnt == 0 ? cnt : cnt + bfs(n, graph, switched);
    }


    public static void main(String[] args) {
        // Test code
        int[][] switches = {{1, 1, 1, 2}, {2, 1, 2, 2}, {1, 1, 1, 3}, {2, 3, 3, 1}, {1, 3, 1, 2}, {1, 3, 2, 1}};
        System.out.println(solution(3, switches));  // 5
    }
}
