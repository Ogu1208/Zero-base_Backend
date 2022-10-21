package Solution.Algorithm_16_3.src;// 알고리즘 - 최단 경로 알고리즘
// 플로이드-워셜

public class Main {

    static int[][] dist;
    static final int INF = 1000000000;

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        
        // 최단 경로 인접 행렬 초기화
        dist = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }
        
        // 그래프 인접 행렬 구성
        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        }
        
        // 플로이드-워셜
        // 노드 각각을 거쳐가는 경우에 대한 반복
        for (int k = 1; k < v + 1; k++) {
            // 노드 i -> j 로 이동하는 각 경우에 대한 거리 업데이트
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 거리 vs i -> k -> j 거리 비교 업데이트
                    // 단방향 그래프에서 다른 간선을 통한 경유를 하지 않기 위한 조건문
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // 출력
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dist[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5d ", dist[i][j]);
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
