package Solution.Java_02_1.src;// Java 프로그래밍 - 변수와 자료형_1

public class Main {
    public static void main(String[] args) {

//      1. 변수 사용하기
        System.out.println("== 변수 사용하기 ==");
        int age = 10;
        String country = "Korea";

        System.out.println("age = " + age);
        System.out.println("country = " + country);
        System.out.println();

//      2. 변수 이름 규칙
        System.out.println("== 변수 이름 규칙 ==");
//      2-1. 문자, 숫자, _(underscore), $ 사용 가능
        int apple = 2000;
        int apple3 = 2000;
        int _apple = 2000;
        int $apple = 2000;

        System.out.println("apple = " + apple);
        System.out.println("apple3 = " + apple3);
        System.out.println("_apple = " + _apple);
        System.out.println("$apple = " + $apple);
        System.out.println();


//      2-2. 숫자로 시작 X
//        int 3apple = 2000;


//      2-3. 대소문자 구분
        int apple1 = 2000;
        int Apple1 = 3000;

        System.out.println("apple1 = " + apple1);
        System.out.println("Apple1 = " + Apple1);
        System.out.println();

//      2-4. 공백 사용 X
//        int one apple = 2000;
        int one_apple = 2000;
        int oneApple = 2000;


//      2-5. 예약어 사용 X
//      예약어 예시: true, false, if, switch, for, continue, break, ...
//        int true = 1;
//        int false = 0;
//        int if = 1;
//        int continue = 10;


//      참고) 한글 사용 가능
        int 나이 = 20;
        System.out.println("나이 = " + 나이);

        
//      3. 표기법
        System.out.println("== 표기법 ==");
//      3-1. 카멜 표기법 (camelCase)
//      변수, 함수
        int myAge = 10;
        int oneApplePrice = 1000;

        
//      3-2. 파스칼 표기법 (PascalCase)
//      클래스
        int MyAge = 10;
        int OneApplePrice = 1000;

        
//      참고) 스네이크 표기법 (snake_case)
//      사용 X
        int my_age = 10;
        int one_apple_price = 1000;

    }
}

