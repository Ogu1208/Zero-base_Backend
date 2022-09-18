/*
    이름 : 김민아
    과제 : 미니과제 07. '로또 당첨 프로그램'
*/


import java.util.*;

public class JavaMini7 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("로또 당첨 프로그램");

        System.out.print("로또 개수를 입력해 주세요.(숫자 1~10): ");
        num = sc.nextInt();

        int[][] lotto = new int[num][6];
        int[] winNum = new int[6];

        // 로또 번호 생성
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < 6; j++) {
                lotto[i][j] = (int) (Math.random() * 45) + 1;
                // 중복 제거
                for (int k = 0; k < j; k++) {
                    if (lotto[i][j] == lotto[i][k]) {
                        j--;
                        break;
                    }
                }
            }
            Arrays.sort(lotto[i]);
        }

        // 당첨 번호 생성

        for (int i = 0; i < 6; i++) {
            winNum[i] = (int) (Math.random() * 45) + 1;
            // 중복 제거
            for (int j = 0; j < i; j++) {
                if (winNum[i] == winNum[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(winNum);


        // 번호 출력
        for (int i = 0; i < lotto.length; i++) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    System.out.printf("%02d", lotto[i][j]);
                } else {
                    System.out.printf("%02d, ", lotto[i][j]);
                }
            }
            System.out.println();
        }


        // 당첨 번호 출력
        System.out.println("\n[로또 발표]");
        System.out.print("\t");
        for (int i = 0; i < winNum.length; i++) {
            if (i == winNum.length - 1) {
                System.out.printf("%02d", winNum[i]);
            } else {
                System.out.printf("%02d, ", winNum[i]);
            }
        }
        System.out.println();

        // 로또 당첨 비교
        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < num; i++) {
            int count = 0;
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    System.out.printf("%02d", lotto[i][j]);
                } else {
                    System.out.printf("%02d, ", lotto[i][j]);
                }
                for (int k = 0; k < 6; k++) {
                    if(winNum[k] == lotto[i][j])
                        count++;
                }
            }
            System.out.printf(" => %d개 일치\n", count);
        }

    }
}
