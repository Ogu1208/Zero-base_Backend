package Java_02_3;

// Java 프로그래밍 - 변수와 자료형_3

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

//      1. 자료형 - 문자열
        System.out.println("== 문자열 ==");
        String s1 = "Hello World!";
        System.out.println("s1 = " + s1);
        String s2 = "01234";
        System.out.println("s2 = " + s2);


//      1-1. equals
        String s3 = "Hi";
        String s4 = "Hi";   // s3와 s4는 같은 문자열 리터럴을 가리킴
        System.out.println(s3.equals(s4));
        System.out.println(s3==s4);
        String s5 = new String("Hi");   // 명시적으로 새롭게 데이터를 생성, 새로운 객체
        System.out.println(s3.equals(s5));   // true (값을 비교)
        System.out.println(s3 == s5);   // false  (객체 비교)


//      1-2. indexOf
        String s6 = "Hello! World!";
        System.out.println(s6.indexOf("!"));
        System.out.println(s6.indexOf("!", s6.indexOf("!")+1));   // 두번째 !를 찾는 방법


//      1-3. replace
        String s7 = s6.replace("Hello", "Bye");
        System.out.println("s7 = " + s7);


//      1-4. substring
        System.out.println(s7.substring(0,3));
        System.out.println(s7.substring(0, s7.indexOf("!") + 1));   // !까지 출력하려면  + 1


//      1-5. toUpperCase
        System.out.println(s7.toUpperCase());


//      2. 자료형 - StringBuffer
        System.out.println("== StringBuffer ==");
        StringBuffer sb1 = new StringBuffer();
        sb1.append("01234");
        System.out.println("sb1 = " + sb1);
        sb1.append("56789");
        System.out.println("sb1 = " + sb1);

        String a = "01234";
        String b = "56789";
        String bak = a;
        System.out.println(a == bak);

        a += b;
        System.out.println(a);
        System.out.println(a == bak);



//      3. 자료형 - 배열
        System.out.println("== 배열 ==");
        int[] myArray1 = {1, 2, 3, 4, 5};
        System.out.println(myArray1[0]);
        System.out.println(myArray1[1]);
        System.out.println(myArray1[2]);
        System.out.println(myArray1[3]);
        System.out.println(myArray1[4]);

        char[] myArray2 = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(myArray2[2]);

        String[] myArray3 = new String[3];
        myArray3[0] = "Hello";
        myArray3[1] = " ";
        myArray3[2] = "World!";
        System.out.println(myArray3[0] + myArray3[1] + myArray3[2]);


    }
}
