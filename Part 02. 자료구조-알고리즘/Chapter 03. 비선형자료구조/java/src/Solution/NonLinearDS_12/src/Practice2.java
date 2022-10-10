package Solution.NonLinearDS_12.src;// Practice2
// 문자열 배열 dictionary 와 문자열 sentence 가 주어졌을 때
// sentence 내의 단어 중 dictionary 의 단어로 시작하는 경우
// 해당 단어로 변경하여 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 dictionary: "cat", "bat", "rat"
// 입력 sentence = "the cattle was rattled by the battery"
// 출력: "the cat was rat by the bat"

// 입력 dictionary: "a", "b", "c"
// 입력 sentence = "apple banana carrot water"
// 출력: "a b c water"


public class Practice2 {
    public static void solution(String[] dictionary, String sentence) {
        // 트라이 구성
        Trie trie = new Trie();
        for (String str : dictionary) {
            trie.insert(str);
        }

        StringBuffer sbResult = new StringBuffer();
        // sentence 단어 별 검사
        for (String word : sentence.split(" ")) {
            Node cur = trie.root;
            StringBuffer sbCur = new StringBuffer();

            for (char c : word.toCharArray()) {
                // 문자 하나 씩 비교하며 sbCur 에 추가
                // dictionary 내에 있는 단어로 시작하는 단어가 아니면 sbCur 에 쌓인 단어 추가
                // dictionary 내에 있는 단어로 시작하면 해당 word 추가
                sbCur.append(c);
                if (cur.child.get(c) != null) {
                    if (cur.child.get(c).isTerminal) {
                        break;
                    }
                    cur = cur.child.get(c);
                } else {
                    sbCur = new StringBuffer(word);
                    break;
                }
            }

            sbResult.append(sbCur);
            sbResult.append(" ");
        }

        System.out.println(sbResult);
    }


    public static void main(String[] args) {
        // Test code
        String[] dictionary = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        solution(dictionary, sentence);

        dictionary = new String[]{"a", "b", "c"};
        sentence = "apple banana carrot water";
        solution(dictionary, sentence);
    }
}
