package Solution.NonLinearDS_12.src;// Practice3
// 문자열 배열 strs 와 targets 가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs 중의 단어가 되는지 판별하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 strs: "apple", "banana", "kiwi"
// 입력 target: "applk", "bpple", "apple"
// 출력: true, true, false


public class Practice3 {
    public static void solution(String[] strs, String[] targets) {
        // 트라이 구성
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        
        // target 별 검사
        for (String target : targets) {
            boolean result = examineWord(trie.root, target, 0, false);
            System.out.print(result + " ");
        }
        System.out.println();
    }

    public static boolean examineWord(Node node, String target, int i, boolean flag){
        if (i < target.length()) {
            // 해당 문자로 시작하는 데이터가 trie 내에 있으면 그 다음 재귀 호출
            if (node.child.containsKey(target.charAt(i))) {
                if (examineWord(node.child.get(target.charAt(i)), target, i + 1, flag)) {
                    return true;
                }
            }

            if (!flag) {
                // 현재 depth 의 문자들 순회하며 비교
                for (char c : node.child.keySet()) {
                    // 문자 하나만 다르고 나머지는 true 일 때 true 반환
                    if (c != target.charAt(i) && examineWord(node.child.get(c), target, i + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
        // flag 가 true 인 상황에서 단어 끝일 때 true 반환
        return flag && node.isTerminal;
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"apple", "banana", "kiwi"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets);    // true, true, false, false, true
    }
}
