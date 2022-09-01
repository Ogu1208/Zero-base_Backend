package Solution.Java_18_1.src;

import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        // 입력 받는 부분
        Scanner sc = new Scanner(System.in);
        System.out.print("알파벳 입력: ");
        char input = sc.nextLine().charAt(0);
        int output = 0;

        // 대소문자 간격
        int step = (int)'a' - (int)'A';

        // 입력 값 예외처리
        if (input >= 'a' && input <= 'z') {
            output = (int)input - step;
            System.out.println("대문자 변환: " + (char)output);
        } else if (input >= 'A' && input <= 'Z'){
            output = (int)input + step;
            System.out.println("소문자 변환: " + (char)output);
        } else {
            System.out.println("입력하신 값은 알파벳이 아닙니다.");
        }
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
