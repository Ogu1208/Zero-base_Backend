package Solution.Math_06.src;// 기초 수학 - 점화식과 재귀함수

public class Main {
    static int recursion1(int n) {
        if (n == 1) {
            return 1;
        }
        return 3 * recursion1(n - 1);
    }

    static int recursion2(int n) {
        if (n == 1) {
            return 1;
        }
        return n + recursion2(n - 1);
    }

    static int recursion3(int n) {
        if (n < 3) {
            return 1;
        }
        return recursion3(n - 2) + recursion3(n -1);
    }

    public static void main(String[] args) {
        
//      점화식 -> 반복문, 재귀함수
        System.out.println("== 점화식/재귀함수 연습1 ==");
//      1, 3, 9, 27, ... 의 n번째 수
        int n = 4;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = 1;
            } else {
                result *= 3;
            }
        }
        System.out.println(result);
        System.out.println(recursion1(n));


        System.out.println("== 점화식/재귀함수 연습2 ==");
//      1, 2, 3, 4, 5, 6, ... 의 n번째 까지의 합
        n = 5;
        result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += i;
        }
        System.out.println(result);
        System.out.println(recursion2(n));


        System.out.println("== 점화식/재귀함수 연습3 ==");
//      1, 1, 2, 3, 5, 8, 13, ...의 n번 째 수
        n = 6;
        result = 0;
        int a1 = 1;
        int a2 = 1;

        if (n < 3) {
            result = 1;
        } else {
            for (int i = 2; i < n; i++) {
                result = a1 + a2;
                a1 = a2;
                a2 = result;
            }
        }
        System.out.println(result);
        System.out.println(recursion3(n));

    }
}
