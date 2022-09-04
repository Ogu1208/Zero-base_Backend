package Java_18_1;

public class Practice4 {
    public static void solution(int n, int type) {
        switch (type) {
            case 1:
                type1(n);
                break;
            case 2:
                type2(n);
                break;
            case 3:
                type3(n);
                break;
            case 4:
                type4(n);
                break;
            case 5:
                type5(n);
                break;
        }

    }

    public static void type1(int n) {
        System.out.println("== Type1 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void type2(int n) {
        System.out.println("== Type2 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type3(int n) {
        System.out.println("== Type3 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type4(int n) {
        System.out.println("== Type4 ==");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void type5(int n) {
        System.out.println("== Type5 ==");
        // 상단부 - 한줄 더 출력 (가운데줄)
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 하단부
        for (int i = n / 2; i > 0; i--) {
            for (int j = 0; j < n / 2 + 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        solution(3, 1);
        solution(3, 2);
        solution(3, 3);
        solution(3, 4);
        solution(7, 5);
    }
}
