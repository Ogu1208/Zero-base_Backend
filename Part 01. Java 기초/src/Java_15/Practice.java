package Java_15;
// Practice
// 로또 번호 만들기

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Practice {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        // 뽑은 데이터를 또 뽑은 경우에는 set.size가 늘어나지 않으므로 들어가지 않는다.
        // Set은 중복 데이터를 허용하지 않기 때문
        // 따라서 중복되지 않은 데이터가 6개 들어갈 때까지 반복문이 돌아감
        for (int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(num);
        }

        LinkedList list = new LinkedList(set);
        Collections.sort(list);
        System.out.println("로또 번호: " + list);


    }
}
