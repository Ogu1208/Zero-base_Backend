package Solution.LinearDS_14_2.src;

import java.util.Hashtable;

public class Practice4 {
    public static String solution(String[] participant, String[] completion) {
        String result = "";
        Hashtable<String, Integer> ht = new Hashtable();

        for (String item: participant) {
            if (ht.containsKey(item)) {
                ht.put(item, ht.get(item) + 1);
            } else {
                ht.put(item, 1);
            }
        }

        for (String item: completion) {
            ht.put(item, ht.get(item) - 1);
        }

        for (String item: participant) {
            if (ht.get(item) > 0) {
                result = item;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
