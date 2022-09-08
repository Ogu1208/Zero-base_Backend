package Solution.Math_07.src;// 기초 수학 - 지수와 로그

public class Main {

    public static void main(String[] args) {

//      1. 제곱, 제곱근, 지수
        System.out.println("== 제곱 ==");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(-2, -3));

        System.out.println(Math.pow(2, 30));
        System.out.printf("%.0f\n", Math.pow(2, 30));

        System.out.println("== 제곱근 ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.pow(16, 1.0/2));
        System.out.println(Math.pow(16, 1.0/4));

//      참고) 절대 값
        System.out.println("== 절대 값 ==");
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));


//      2. 로그
        System.out.println("== 로그 ==");
        System.out.println(Math.log(2.7182818284590452353602874713527));
        System.out.println(Math.log10(1000));
        System.out.println(Math.log(4) / Math.log(2));

    }
}
