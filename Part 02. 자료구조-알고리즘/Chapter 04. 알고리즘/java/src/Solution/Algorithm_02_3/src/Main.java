package Solution.Algorithm_02_3.src;// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void radixSort(int[] arr) {
        // 기수 테이블 생성
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(new LinkedList());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr);
        // 자리수 만큼 기수 정렬 반복
        for (int i = 0; i < maxLen; i++)
        {
            // 각 자리수에 맞는 큐 위치에 데이터 삽입
            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            // 다시 순서대로 가져와서 배치
            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);

                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;
        }
    }

    public static int getMaxLen(int[] arr)
    {
        // 배열에 숫자들 중 가장 긴 자리수 구하기
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
