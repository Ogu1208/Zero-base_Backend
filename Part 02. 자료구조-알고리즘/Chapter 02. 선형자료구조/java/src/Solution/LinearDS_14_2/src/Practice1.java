package Solution.LinearDS_14_2.src;

import java.util.LinkedList;
import java.util.Queue;

class Doc {
    int no;
    int priority;

    public Doc(int no, int priority) {
        this.no = no;
        this.priority = priority;
    }
}

public class Practice1 {
    public static void solution(int docs, int target, int[] priority) {
        Queue<Doc> queue = new LinkedList();

        for (int i = 0; i < docs; i++) {
            queue.add(new Doc(i, priority[i]));
        }

        int cnt = 1;
        while (true) {
            Doc cur = queue.poll();

            Doc[] highP = queue.stream().filter(x -> x.priority > cur.priority).toArray(Doc[]::new);

            if (highP.length > 0) {
                queue.add(cur);
            } else {
                if (cur.no == target) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
    }
}
