package Practice.LinearDS_13.src;// Practice3
// 참고 - Hashtable? HashMap?

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Practice3 {
    public static void main(String[] args) {
        // Hashtable
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        ht.put(0, 10);
        System.out.println(ht.get(0));


        // HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 10);
        System.out.println(hm.get(0));

        Map<Integer, Integer> map1 = ht;
        Map<Integer, Integer> map2 = hm;

        System.out.println(map1.get(0));
        System.out.println(map2.get(0));


        // Hashtable에는 null을 이용한 key값을 넣을 수 없다.
//        ht.put(null, -999);
//        System.out.println(ht.get(null));

        // HasmMap은 null을 이용한 key 값을 쓸 수 있다.
        hm.put(null, -999);
        System.out.println(hm.get(null));

        // Hashtable과 HasmMap 차이
        // 공통: 둘 다 Map 인터페이스를 구현하 ㄴ것
        // 차이 :
            // Key 에 Null 사용 여부
            // Hashtable: X
            // HasghhMap: 0;

            // Thread-safe
            // Hashtable: 0 (멀티 스레드 환경에서 우수)
            // HashMap: X (싱글 스레드 환경에서 우수)
            // 참고) synchronizedMap, ConcurrentHashMap
    }
}
