package Solution.NonLinearDS_13_3.src;

public class Practice5 {
    public static double solution(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        if (words.length == 1) {
            return 1;
        }

        // Trie 구성
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // 입력해야 하는 횟수 세기
        double sum = 0;
        for (String word : words) {
            // 첫 문자 입력하고 시작
            sum += 1;
            Node cur = trie.root;
            cur = cur.child.get(word.charAt(0));

            for (int i = 1; i < word.length(); i++) {
                // 현재 문자에서 다음 문자로의 갈래가 여러개면 입력 필요하므로 1 증가
                if (cur.child.size() > 1) {
                    sum += 1;
                } else if (cur.child.size() == 1 && cur.isTerminal) {
                    // 해당 문자로 끝나는 단어가 있는 경우 다음 입력 필요하므로 1 증가
                    sum += 1;
                }

                cur = cur.child.get(word.charAt(i));
            }
        }

        return sum / words.length;
    }

    public static void main(String[] args) {
        // Test code
        String[] words = {"hell", "hello", "heaven", "java"};
        System.out.printf("%.2f\n", solution(words));   // (2 + 3 + 2 + 1) / 4 = 2.00

        words = new String[] {"abca", "abcb", "abcc"};  // (2 + 2 + 2) / 3 = 2.00
        System.out.printf("%.2f\n", solution(words));

        words = new String[] {"cloud", "cloudy", "rain", "rainy", "sun", "sunny"};
        System.out.printf("%.2f\n", solution(words));   // (1 + 2 + 1 + 2 + 1 + 2) / 6 = 1.50
    }
}
