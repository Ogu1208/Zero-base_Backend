package Solution.NonLinearDS_06.src;// Practice1
// Center Node 찾기
// Undirected 그래프에서 center node 를 출력하세요.
// Center node 는 다른 모든 노드와 연결된 노드를 의미
// 다른 모드와 연결된 노드는 하나라고 가정

// 입력 그래프: {{1, 2}, {2, 3}, {4, 2}}
// 출력: 2

// 입력 그래프: {{1,2}, {5,1}, {1,3}, {1,4}}
// 출력: 1

class MyGraphMatrix {
    char vertices[];
    int[][] adjMat;
    int elemCnt;

    public  MyGraphMatrix() {}
    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    public void addDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char item: this.vertices) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}


public class Practice1 {
    public static int solution(int[][] e) {
        MyGraphMatrix graph = new MyGraphMatrix(e.length + 1);

        for (int i = 0; i < e.length; i++) {
            graph.addEdge(e[i][0] - 1, e[i][1] - 1);
        }

        int[] edgeCnt = new int[e.length + 1];
        for (int i = 0; i < graph.adjMat.length; i++) {
            for (int j = 0; j < graph.adjMat[i].length; j++) {
                if (graph.adjMat[i][j] == 1) {
                    edgeCnt[i] += 1;
                }
            }
        }

        int maxCnt = -1;
        int maxIdx = -1;
        for (int i = 0; i < edgeCnt.length; i++) {
            if (maxCnt < edgeCnt[i]) {
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }

        return maxIdx + 1;
    }

    public static int solution2(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public static void main(String[] args) {
        // Test code
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();
        
        edges = new int[][]{{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
