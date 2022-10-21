package Solution.Algorithm_16_1.src;// 다익스트라 우선순위 큐 사용

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main2 {

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        // 그래프 구성
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // 최단거리 dp 메모리
        int[] dist = new int[v + 1];

        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        // PQ (Min Heap)
        PriorityQueue<Node> q = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        q.offer(new Node(start, 0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();

            // 현재 노드 위치로의 거리 값이 현재 노드 선의 거리 값보다 작으면 continue 처리
            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            // 인접 노드 체크
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 기존 거리 값보다 현재 노드에서 해당 노드로 가는 길의 거리 값이 더 작으면 업데이트 하고,
                // 해당 노드 pq에 추가
                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    q.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
