package Solution.Math_02.src;// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용 X)

import java.util.ArrayList;

class MySet {
    ArrayList<Integer> list;

    MySet() {
        this.list = new ArrayList<Integer>();
    }

    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for(int item: arr) {
            this.list.add(item);
        }
    }

// 원소 추가 (중복 X)
    public void add(int x) {
        for (int item: this.list) {
            if (item == x) {
                return;
            }
        }
        this.list.add(x);
    }

// 교집합
    public MySet retainAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            for (int itemB: b.list) {
                if (itemA == itemB) {
                    result.add(itemA);
                }
            }
        }
        return result;
    }

// 합집합
    public MySet addAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            result.add(itemA);
        }

        for (int itemB: b.list) {
            result.add(itemB);
        }
        return result;
    }

// 차집합
    public MySet removeAll(MySet b) {
        MySet result = new MySet();

        for (int itemA: this.list) {
            boolean containFlag = false;

            for (int itemB: b.list) {
                if (itemA == itemB) {
                    containFlag = true;
                    break;
                }
            }

            if (!containFlag) {
                result.add(itemA);
            }
        }
        return result;
    }
}

public class Practice {
    public static void main(String[] args) {

//      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
