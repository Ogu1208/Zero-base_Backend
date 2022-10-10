package Solution.NonLinearDS_09.src;// Practice 1
// 자바 기본 PriorityQueue 응용

import java.util.Arrays;
import java.util.PriorityQueue;

// 1. 이렇게 하면 에러 발생
//class Person {
// 2. Comparable interface 이용
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
// 필수 오버라이드
    @Override
    public int compareTo(Person o) {
        // 1: 변경 안함
        // -1: 변경
        // 새롭게 추가하는 데이터가 더 작을 때 변경 (작은 값이 위로 올라감, 오름 차순)
        return this.age >= o.age ? 1 : -1;

        // 새롭게 추가하는 데이터가 더 클 때 변경 (큰 값이 위로 올라감, 내림 차순)
//        return this.age >= o.age ? -1 : 1;
    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> pq = new PriorityQueue();

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }
        System.out.println("== 내부 힙 구조 ==");
        pq.stream().forEach(x -> System.out.println(x.name + " " +  x.age));
        System.out.println();

        System.out.println("== 실제 출력 순서 ==");
        while (!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        // 다른 방식
        System.out.println();
        PriorityQueue<Person> pq2 = new PriorityQueue<>((Person p1, Person p2) -> p1.age >= p2.age ? 1 : -1);

        for (int i = 0; i < name.length; i++) {
            pq2.offer(new Person(name[i], age[i]));
        }

        while (!pq2.isEmpty()) {
            Person p = pq2.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
}
