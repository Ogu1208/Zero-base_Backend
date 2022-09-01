package Solution.Java_15.src;// Practice
// 로또 번호 만들기

import java.util.*;

public class Practice {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(num);
        }

        LinkedList list = new LinkedList(set);
        Collections.sort(list);
        System.out.println("로또 번호: " + list);
    }
}
