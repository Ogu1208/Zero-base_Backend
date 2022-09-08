package Solution.Math_05.src;// 기초 수학 - 조합

public class Main {
    int getNumOfCombination(int n, int r) {
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }

        return pResult / fResult;
    }

    public static void main(String[] args) {
//      1. 조합
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }

        System.out.println(pResult / fResult);


//      2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;

        int hResult = new Main().getNumOfCombination(n + r - 1, r);
        System.out.println(hResult);

    }
}
