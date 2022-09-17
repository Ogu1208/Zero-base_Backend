/*
    이름 : 김민아
    과제 : 미니과제 07. '로또 당첨 프로그램'
*/


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class JavaMini7 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("로또 당첨 프로그램");

        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10): ");
        num = sc.nextInt();

        int[][] lotto = new int[num][6];

        // 로또 번호 생성
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < 6; j++) {
                int n = (int) (Math.random() * 45) + 1;
                lotto[i][j] = n;
                for (int k = 0; k < j; k++) {
                    if (lotto[i][j] == lotto[i][k])
                        j--;
                    break;
                }
            }
            Arrays.sort(lotto[i]);
        }

        // 로또 번호 생성
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < 6; j++) {
                int n = (int) (Math.random() * 45) + 1;
                lotto[i][j] = n;
                for (int k = 0; k < j; k++) {
                    if (lotto[i][j] == lotto[i][k])
                        j--;
                    break;
                }
            }
            Arrays.sort(lotto[i]);
        }


        // 번호 출력
        for (int i = 0; i < lotto.length; i++) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < 6; j++) {
                if(j==5) {
                    System.out.printf("%02d", lotto[i][j]);
                } else {
                    System.out.printf("%02d, ", lotto[i][j]);
                }
            }
            System.out.println();
        }
    }
}
