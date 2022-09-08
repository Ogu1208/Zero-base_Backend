package Solution.Math_07.src;// Practice
// 제곱과 제곱근을 Math 없이 구현하기

public class Practice {
    static double pow(int a, double b) {
        double result = 1;
        boolean isMinus = false;

        if (b == 0) {
            return 1;
        } else if (b < 0) {
            b *= -1;
            isMinus = true;
        }

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        return isMinus ? 1 / result : result;
    }

    static double sqrt(int a) {
        double result = 1;
        for (int i = 0; i < 10; i++) {
            result = (result + (a / result)) / 2;
        }

        return result;
    }

    public static void main(String[] args) {

//      Test code
        System.out.println("== Math pow ==");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println("== My pow ==");
        System.out.println(pow(2, 3));
        System.out.println(pow(2, -3));
        System.out.println(pow(-2, -3));

        System.out.println("== Math sqrt ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));

        System.out.println("== My sqrt ==");
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));

    }
}
