/*
    이름 : 김민아
    과제 : 미니과제 05. '달력 출력 프로그램'
*/


import java.util.Calendar;
import java.util.Scanner;

public class JavaMini5 {
    public static void main(String[] args) {
        int year;
        int month;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[달력 출력 프로그램]");

            System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
            year = sc.nextInt();
            if (year < 1800 || year > 2022) {
                System.out.print("달력의 년도를 다시 입력해 주세요.");
                continue;
            }

            System.out.print("달력의 월을 입력해 주세요.(mm): ");
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                System.out.print("달력의 월을 다시 입력해 주세요.");
                continue;
            }

            System.out.printf("[%d년 %02d월]\n", year, month);
            printCalender(year, month);
            System.out.println();
            System.out.println();
        }
    }

    public static void printCalender(int year, int month) {
//        요일 (1 ~ 7, 1 : 일요일)
        int START_DAY_OF_WEEK = 0;  // 시작하는 요일
        int END_DAY = 0;
        Calendar sDay = Calendar.getInstance();
        Calendar eDay = Calendar.getInstance();

        // 월 (0~11)
        sDay.set(year, month - 1, 1);
        eDay.set(year, month, 1);

        // 그 달의 마지막날 = 다음달의 첫날에서 하루를 뺀다.
        eDay.add(Calendar.DATE, -1);
        END_DAY = eDay.get(Calendar.DATE);

        // 시작날이 무슨요일인지
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        System.out.println("|일  월  화  수  목  금  토|");

        for (int i = 1; i < START_DAY_OF_WEEK; i++) {
            System.out.print("    ");
        }

        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
//            System.out.print((i < 10) ? "  " + i : " " + i);
            System.out.printf("%02d\t", i);
            if (n % 7 == 0) System.out.println();
        }
    }
}


