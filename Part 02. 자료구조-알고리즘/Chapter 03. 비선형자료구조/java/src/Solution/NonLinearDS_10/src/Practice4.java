package Solution.NonLinearDS_10.src;// Practice4
// 문자열 s 가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하세요.
// 재배치가 가능한 경우 재정렬한 문자열을 반환하고 불가능한 경우 null 을 반환하세요.

// 입출력 예시
// 입력: "aabb"
// 출력: "abab"

// 입력: "aaca"
// 출력: null

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice4 {
    public static String solution(String s) {
        // 알파벳 별 빈도수 기록
        HashMap<String, Integer> map = new HashMap<>();
        for(String item: s.split("")){
            map.put(item, map.getOrDefault(item,0) + 1);
        }

        // 빈도수 기준 maxHeap
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        
        for(Map.Entry<String, Integer> item: map.entrySet()){
            pq.add(item);
        }
        
        // 빈도수가 높은 알파벳부터 나오며,
        // 알파벳 하나를 배치하고 그 다음 알파벳을 꺼낸 후 이전의 알파벳 빈도수가 남아있으면 다시 넣어줌
        // 이렇게 하면 교차로 알파벳을 배치시킬 수 있음
        StringBuffer sb = new StringBuffer();
        Map.Entry<String, Integer> prev = null;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> cur = pq.poll();
            
            // 이전 알파벳의 빈도수가 남아있었다면 pq 에 다시 넣어줌
            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }
            
            // sb 에 알파벳 연결 후 해당 빈도수 감소
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);

            // 현재 알파벳에 대한 빈도수가 남아 있는데 pq 가 비어있으면,
            // 더 이상 교차로 배치시킬 알파벳이 없으므로 null 반환
            prev = cur;
            if (pq.isEmpty() && prev.getValue() > 0) {
                return null;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}
