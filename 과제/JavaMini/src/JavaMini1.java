/*
    이름 : 김민아
    과제 : 미니과제 01. '콘솔 화면에 구구단 출력하기'
*/


public class JavaMini1 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf(String.format("%02d x %02d = %02d \t", j + 1, i + 1, (j + 1) * (i + 1)));
            }
            System.out.println();

        }
    }
}
