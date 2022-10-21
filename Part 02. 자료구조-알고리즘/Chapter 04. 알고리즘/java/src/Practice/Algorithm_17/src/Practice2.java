package Practice.Algorithm_17.src;// Practice2
// N 개의 우주가 있고, N 개의 우주 사이에 M 개의 포탈과 W 개의 웜홀이 있다.
// 각 포탈에는 시간 비용이 있고, 포탈을 통해 우주를 이동했을 때 시간이 흘러 있다.
// 웜홀에도 시간 비용이 있는데, 웜홀을 통해 우주를 이동하는 경우는 시간이 거꾸로 흘러 있다.
// N 개의 우주를 포탈과 웜홀을 통해 이동 한다고 했을 때,
// 출발 했을 때보다 시간이 거꾸로 흘러가 있는 경우가 있는지 판별하는 프로그램을 작성하세요.

// 흘러가 있는 경우가 없으면 false, 있으면 true 를 출력하세요.

// 입출력 예시)
// 입력:
// n: 3 / m: 3 / w: 1
// portal: {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}}
// wormhole: {{3, 1, 3}}

// 출력: false


public class Practice2 {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    final static int INF = 1000000000;
    static Edge[] edge;
    static int[] dist;

    public static void solution(int n, int m, int w, int[][] portal, int[][] wormhole) {

    }

    public static boolean bellmanFord(int v, int e) {

        return false;
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int m = 3;
        int w = 1;
        int[][] portal = {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}};
        int[][] wormhole = {{3, 1, 3}};

        solution(n, m, w, portal, wormhole);  // false

        n = 3;
        m = 2;
        w = 1;
        portal = new int[][] {{1, 2, 3}, {2, 3, 4}};
        wormhole = new int[][] {{3, 1, 8}};
        solution(n, m, w, portal, wormhole);  // true
    }
}
