package Practice.LinearDS_12.src;// 선형 자료구조 - 해시 테이블

import java.util.Hashtable;
import java.util.Map;

public class Main {
    // 해시 함수
    public static int getHash(int key) {
        return key % 5;
    }

    public static void main(String[] args) {
        // 기본 해시 테이블 사용 방법
        Hashtable<String, Integer> ht = new Hashtable();

        ht.put("key1", 10);
        ht.put("key2", 20);
        ht.put("key3", 30);
        ht.put("key3", 50);

        for (Map.Entry<String, Integer> item : ht.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }


        // 해시 충돌 케이스 (해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable();
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("== 충돌 전 ==");
        for (Map.Entry<Integer, Integer> item : ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        ht2.put(getHash(6), 60);
        System.out.println("== 충돌 후 ==");
        for (Map.Entry<Integer, Integer> item : ht2.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

    }
}
