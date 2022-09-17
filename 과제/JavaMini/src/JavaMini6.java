/*
    이름 : 김민아
    과제 : 미니과제 06. '가산 댕선 당선 시뮬레이션 프로그램'
*/


import java.util.Random;
import java.util.Scanner;

public class JavaMini6 {

    public static void main(String[] args) {
        int count = 1;              // 투표자 수
        int[] votes = new int[4];   // 투표수 배열 (0:이재명, 1:윤석열, 2:심상정, 3:안철수
        double progress = 0.0;      // 투표 진행률
        int voteNum;                // 투표 index
        int max = 0;                // 투표 최다 index
        String[] candidate = {"이재명", "윤석열", "심상정", "안철수"};  // 후보자

        while (count <= 10000) {
            progress = count / 10000.0 * 100;
            voteNum = new Random().nextInt(4);
            votes[voteNum]++;

            for (int i = 1; i < votes.length; i++) {
                if (votes[i] > votes[max])
                    max = i;
            }

            System.out.printf("[투표 진행율]: %.2f%%, %d명 투표 => %s\n", progress, count, candidate[max]);
            System.out.printf("[기호:1] 이재명: %.2f%%, (투표수: %d)\n", (votes[0]/10000.0)*100, votes[0]);
            System.out.printf("[기호:2] 윤석열: %.2f%%, (투표수: %d)\n", (votes[0]/10000.0)*100, votes[1]);
            System.out.printf("[기호:1] 심상정: %.2f%%, (투표수: %d)\n", (votes[0]/10000.0)*100, votes[2]);
            System.out.printf("[기호:1] 안철수: %.2f%%, (투표수: %d)\n", (votes[0]/10000.0)*100, votes[3]);

            count++;
        }

        // 투표 결과 출력
        System.out.println("[투표결과] 당선인 : " + candidate[max]);
    }
}
