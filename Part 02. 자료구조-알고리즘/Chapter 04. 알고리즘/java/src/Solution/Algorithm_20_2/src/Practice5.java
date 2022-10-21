package Solution.Algorithm_20_2.src;

import java.util.PriorityQueue;

public class Practice5 {
    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static boolean[] visited;

    public static int solution(int[][] points) {
        visited = new boolean[points.length];

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(0, 0));

        int weightSum = 0;

        int cnt = 0;
        while (cnt < points.length) {
            Node cur = pq.poll();

            if (visited[cur.idx]) {
                continue;
            }
            
            visited[cur.idx] = true;
            weightSum += cur.weight;
            cnt++;

            // 인접한 점들과의 거리 계산하여 pq에 추가
            for (int i = 0; i < points.length; i++) {
                // 동일 노드 제외
                if (i == cur.idx) {
                    continue;
                }
                // 맨해튼 거리
                int distance =
                        Math.abs(points[i][0] - points[cur.idx][0]) + Math.abs(points[i][1] - points[cur.idx][1]);
                pq.add(new Node(i, distance));
            }
        }

        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(solution(points));

        points = new int[][]{{-4, 1}, {3, 12}, {-2, 5}};
        System.out.println(solution(points));
    }
}
