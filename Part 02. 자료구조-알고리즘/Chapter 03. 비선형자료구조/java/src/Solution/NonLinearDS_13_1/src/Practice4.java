package Solution.NonLinearDS_13_1.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {
    public static int solution(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }
        
        // deadends 의 목록을 visited 에 할당
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        
        // bfs 를 위한 queue 생성
        Queue<String> queue = new LinkedList<>();
        // 0000 에서 시작
        queue.offer("0000");
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNum = queue.poll();

                // deadends 에 해당하면 queue 에 남은 부분 수행하기 위해 continue
                if (!visited.add(curNum)) {
                    continue;
                }

                // target 에 도달하면 이동 횟수 반환
                if (curNum.equals(target)) {
                    return cnt;
                }

                // 다음으로 이동 가능한 경우에 대해 queue 에 추가
                for (String nextNum : getNextNums(curNum.toCharArray())) {
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public static LinkedList<String> getNextNums(char[] cArr) {
        LinkedList<String> nums = new LinkedList<>();
        // 각 자리에 대해 위 아래 이동에 대한 숫자 추가
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            cArr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c;
        }
        return nums;
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[] {"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
