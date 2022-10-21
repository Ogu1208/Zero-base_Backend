package Solution.Algorithm_08.src;// 알고리즘 - 그리디 알고리즘
// Activity Selection Problem

import java.util.ArrayList;
import java.util.Collections;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void selectActivity(ArrayList<Activity> list) {
        // 종료시간 기준 오름차순 정렬
        Collections.sort(list, (x1, x2) -> x1.end - x2.end);

        int curTime = 0;
        ArrayList<Activity> result = new ArrayList<>();
        for (Activity item: list) {
            // 활동의 시작 시간이 현재 시간보다 작으면 추가
            if (curTime <= item.start) {
                // 다음 활동 시간 비교를 위해 현재 활동의 종료 시간으로 업데이트
                curTime = item.end;
                result.add(item);
            }
        }
        
        // 출력
        for (Activity item: result) {
            System.out.print(item.name + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }
}
