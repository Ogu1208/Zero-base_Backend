package Practice.NonLinearDS_13_2.src;

import java.util.ArrayList;
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

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Practice5 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {

        return null;
    }

    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }
}
