package Practice.Algorithm_17.src;// Practice3
// n 개의 도시와, 한 도시에서 출발하여 다른 도시에 도착하는 m 개의 버스가 있다.
// 각 버스는 한 번 사용할 때 필요한 비용이 있다.
// 모든 도시의 쌍 (A, B) 에 대해서 도시 A 에서 B 로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
// 갈수 없는 경로는 0을 출력하세요.

// 입출력 예시)
// 입력 busInfo: {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2}, {3, 4, 1}, {3, 5, 1},
//              {4, 5, 3}, {3, 5, 10}, {3, 1, 8}, {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}}
// 출력:
//    0     2     3     1     4
//   12     0    15     2     5
//    8     5     0     1     1
//   10     7    13     0     3
//    7     4    10     6     0

public class Practice3 {

    static int[][] dist;
    static final int INF = 1000000000;

    public static void solution(int city, int bus, int[][] busInfo) {

    }

    public static void floydWarshall(int v) {

    }

    public static void main(String[] args) {
        // Test code
        int city = 5;
        int bus = 14;
        int[][] busInfo = {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2}, {3, 4, 1}, {3, 5, 1},
                {4, 5, 3}, {3, 5, 10}, {3, 1, 8}, {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}};
        solution(city, bus, busInfo);
    }
}
