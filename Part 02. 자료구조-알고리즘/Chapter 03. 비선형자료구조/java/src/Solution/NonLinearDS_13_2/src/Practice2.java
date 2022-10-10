package Solution.NonLinearDS_13_2.src;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice2 {
    public static int[] solution(int[][] intervals, int[] queries) {
        // 정렬 전 데이터 순서 기록
        int[][] queriesBak = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesBak[i] = new int[]{queries[i], i};
        }

        // 간격 기준 min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((x, y) -> ((x[1] - x[0]) - (y[1] - y[0])));

        // 시작간격 기준 오름차순 정렬
        // 오름차순 정렬해둔 상태에서 힙 업데이트 해가면서 출력
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        Arrays.sort(queriesBak, (x, y) -> (x[0] - y[0]));

        int[] result = new int[queries.length];

        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int queryVal = queriesBak[i][0];
            int queryIndex = queriesBak[i][1];

            // 현재 쿼리 값 보다 시작 값이 작은 구간에 대해 추가
            while(j < intervals.length && intervals[j][0] <= queryVal){
                minHeap.add(intervals[j]);
                j++;
            }
            
            // 현재 쿼리 값 보다 종료 값이 작은 구간에 대해 제거
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal){
                minHeap.remove();
            }

            // 힙이 비어있으면 만족하는 구간 없음
            // 있으면 가장 최상단의 구간이 최소 구간에 해당
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));
    }
}
