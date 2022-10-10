package Practice.NonLinearDS_09.src;// 비선형 자료구조 - 우선순위 큐
// 연결 리스트를 이용한 우선순위 큐
// 자바 기본 PriorityQueue

import java.util.*;

public class Main {
    public static void enqueue(LinkedList<Integer> list, int data) {

    }

    public static Integer dequeue(LinkedList<Integer> list) {

        return null;
    }

    public static void main(String[] args) {
        // 연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바 기본 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 우선순위: 낮은 숫자 순


        // 우선순위: 높은 숫자 순


    }
}
