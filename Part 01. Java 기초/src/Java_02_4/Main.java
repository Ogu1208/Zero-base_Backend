package Java_02_4;

// Java 프로그래밍 - 변수와 자료형_4


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 리스트
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();

//      1-1. add
        l1.add(1);
        l1.add("hello");
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add("world!");
        System.out.println("li = " + l1);

        l1.add(0, 1);
        System.out.println("l1 = " + l1);

//      1-2. get
        System.out.println(l1.get(0));
        System.out.println(l1.get(3));


//      1-3. size
        System.out.println(l1.size());

//      1-4. remove
        System.out.println(l1.remove(0));
        System.out.println("l1 = " + l1);

        System.out.println(l1.remove(Integer.valueOf(2)));   // list에 있는 2라는 값을 지워줌 (index가 아니고)
        System.out.println("l1 = " + l1);


//      1-5. clear
        l1.clear();
        System.out.println("l1 = " + l1);


//      1-6. sort
        ArrayList l2 = new ArrayList();
        l2.add(5);
        l2.add(3);
        l2.add(4);
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.naturalOrder());
        System.out.println("l2 = " + l2);
        l2.sort(Comparator.reverseOrder());
        System.out.println("l2 = " + l2);


//      1-7. contains
        System.out.println(l2.contains(1));
        System.out.println(l2.contains(4));


//      2. Maps
        System.out.println("== Maps ==");
        HashMap map = new HashMap();


//      2-1. put
        map.put("kiwi", 9000);
        map.put("apple", 10000);
        map.put("mango", 12000);
        System.out.println("map = " + map);


//      2-2. get
        System.out.println(map.get("mandarine"));  // null
        System.out.println(map.get("kiwi"));        // 9000


//      2-3. size
        System.out.println(map.size());


//      2-4. remove
        System.out.println(map.remove("kiwi"));    // value를 되돌려줌
        System.out.println(map.remove("mandarine"));   // null
        System.out.println("map = " + map);


//      2-5. containsKey
        System.out.println(map.containsKey("apple"));
        System.out.println(map.containsKey("kiwi"));



//      3. Generics
//        자료  형을 제한
        System.out.println("== Generics ==");
        ArrayList l3 = new ArrayList();
        l3.add(1);
        l3.add("hello");
        System.out.println("l3 = " + l3);

        ArrayList<String> l4 = new ArrayList<String>();
//        l4.add(1);
        l4.add("hello");
        System.out.println("l4 = " + l4);


        HashMap map1 = new HashMap();
        map1.put(123, "id");
        map1.put("apple", 10000);
        System.out.println("map1 = " + map1);

        HashMap<String, Integer> map2 = new HashMap<>();
//        map2.put(123, "id");
        map2.put("apple", 10000);
        System.out.println("map2 = " + map2);

    }

}

