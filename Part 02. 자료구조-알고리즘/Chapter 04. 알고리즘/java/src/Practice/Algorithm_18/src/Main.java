package Practice.Algorithm_18.src;// 알고리즘 - 최소 신장 트리
// 크루스칼 알고리즘

public class Main {

    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;


        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(kruskal(graph, v, e));
    }
}
