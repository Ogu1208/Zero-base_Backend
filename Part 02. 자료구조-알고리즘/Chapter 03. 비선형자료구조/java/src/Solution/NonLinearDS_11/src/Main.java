package Solution.NonLinearDS_11.src;// 비선형 자료구조 - 트라이 (Trie)

import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    // 단어 끝인지 체크 용
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
            
            // 현재 노드 기준 c 문자에 해당하는 노드가 없으면 추가
            cur.child.putIfAbsent(c, new Node());
            // 이어서 추가하기 위해 다음 문자 쪽으로 이동
            cur = cur.child.get(c);

            // str 끝이면 true 체크 후 return
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
            
            // 해당 단어 있으면 이동, 없으면 false 반환
            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            // i 가 str 끝에 도달했지만 cur 의 terminal 이 true 아니면
            // 해당 단어가 들어 있는 것은 아니므로 false 반환
            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제 완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    public boolean delete(Node node, String str, int idx) {
        char c = str.charAt(idx);

        // 없는 단어인 경우 false 반환
        if (!node.child.containsKey(c)) {
            return false;
        }

        Node cur = node.child.get(c);
        idx++;
        
        // 단어의 가장 끝에 도달 후 삭제 결정
        if (idx == str.length()) {
            // 끝에 도달했지만 terminal true 아닌 경우
            // 해당 단어와 일치하는 것은 아니므로 false 반환
            if (!cur.isTerminal) {
                return false;
            }
            
            // 해당 단어와 일치할 경우 isTerminal false 로 변경
            cur.isTerminal = false;
            // 그 외의 문자 없는 경우 삭제
            if (cur.child.isEmpty()) {
                node.child.remove(c);
            }
        } else {
            if (!this.delete(cur, str, idx)) {
                return false;
            }
            
            // 끝 문자 삭제 후 앞의 문자들에서 파생되는 단어들 없으면 함께 삭제
            if (!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple");
    }
}
