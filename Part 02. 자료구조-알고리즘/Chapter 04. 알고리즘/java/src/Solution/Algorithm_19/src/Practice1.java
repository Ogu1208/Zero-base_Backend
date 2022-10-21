package Solution.Algorithm_19.src;// Practice1
// 2250년, 인류는 지구 뿐 아니라 여러 행성을 다니며 살고 있다.
// 이 행성 간을 빨리 오가기 위해 새롭게 터널을 구축하려 한다.

// 행성은 (x, y, z) 좌표로 주어진다.
// 행성1: (x1, y1, z1), 행성2: (x2, y2, z2)
// 이 때 행성간 터널 연결 비용은 min(|x1-x2|, |y1-y2|, |z1-z2|) 로 계산한다.

// n 개의 행성 사이를 n-1 개의 터널로 연결하는데 드는 최소 비용을 구하는 프로그램을 작성하세요.

// 입출력 예시
// 입력:
// data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}}
// 출력: 4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practice1 {

    static class Point {
        int idx;
        int x;
        int y;
        int z;

        Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

    }

    static int parents[];
    static ArrayList<Edge> edges;

    public static int solution(int[][] data) {
        int n = data.length;

        // 행성의 각 좌표 초기화
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(i, data[i][0], data[i][1], data[i][2]);
        }

        edges = new ArrayList<>();

        // x 축 기준 간선 추가
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].x - points[i + 1].x);
            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
        }

        // y 축 기준 간선 추가
        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].y - points[i + 1].y);
            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
        }

        // z 축 기준 간선 추가
        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].z - points[i + 1].z);
            edges.add(new Edge(points[i].idx, points[i + 1].idx, weight));
        }

        // weight 기준 graph 정렬
        Collections.sort(edges);
        return kruskal(n, edges);
    }

    public static int kruskal(int n, ArrayList<Edge> edges) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int weightSum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                weightSum += edge.weight;
            }
        }

        return weightSum;
    }

    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}};
        System.out.println(solution(data));
    }
}
