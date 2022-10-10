package Solution.NonLinearDS_13_3.src;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }
}

public class Practice4 {
    public static boolean solution(String[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Trie trie = new Trie();

        // 우선 트라이에 문자열 하나 추가
        trie.insert(nums[0]);

        // 그 다음 문자열 부터는 prefix 검사 하면서 추가
        // prefix 에 해당하면 false
        // prefix 에 해당하지 않으면 계속 추가
        for (int i = 1; i < nums.length; i++) {
            if (isPrefix(trie.root, nums[i])) {
                return false;
            } else {
                trie.insert(nums[i]);
            }
        }

        return true;
    }

    public static boolean isPrefix(Node node, String prefix) {
        Node cur = node;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.child.get(c) == null) {
                return false;
            }

            cur = cur.child.get(c);

            if (cur.isTerminal) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        String[] nums = {"911", "123456789", "911234"};
        System.out.println(solution(nums)); // false

        nums = new String[]{"113", "12345", "12344", "98765"};
        System.out.println(solution(nums)); // true

    }
}
