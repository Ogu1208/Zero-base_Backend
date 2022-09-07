/*
    이름 : 김민아
    과제 : 미니과제 04. '주민등록번호 생성 프로그램'
*/


import java.util.Random;
import java.util.Scanner;

public class JavaMini4 {
    public static void main(String[] args) {
        int year;
        int month;
        int day;
        char gender;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[주민등록번호 계산]");

            System.out.print("출생년도를 입력해 주세요.(yyyy): ");
            year = sc.nextInt();
            if (year < 1800 || year > 2022) {
                System.out.print("출생년도를 다시 입력해 주세요.");
                continue;
            }


            System.out.print("출생월을 입력해 주세요.(mm): ");
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                System.out.print("출생월을 다시 입력해 주세요.");
                continue;
            }

            System.out.print("출생일을 입력해 주세요.(dd): ");
            day = sc.nextInt();
            if (day < 1 || day > 31) {
                System.out.print("출생일을 다시 입력해 주세요.");
                continue;
            }

            System.out.print("성별을 입력해 주세요.(m/f): ");
            gender = (char) Character.toLowerCase(sc.next().charAt(0));
            if (gender != 'm' && gender != 'f') {
                System.out.print("성별을 다시 입력해 주세요.");
                continue;
            }

            System.out.println(makeSSN(year, month, day, gender));
            System.out.println();
        }

    }

    public static StringBuilder makeSSN(int year, int month, int day, char gender) {
        StringBuilder SSN = new StringBuilder();
        SSN.append(Integer.toString(year % 100))   // 출생년도
                .append(String.format("%02d", month))   // 출생월
                .append(String.format("%02d", day))     // 출생일
                .append("-")
                .append(Integer.toString(getGenderNum(year, gender)))  // 뒷자리 첫번째자리(성별)
                .append(Integer.toString(new Random().nextInt(100000))); // 6자리 임의 번호

        return SSN;
    }

    public static int getGenderNum(int year, char gender) {
        if (year >= 1800 && year < 1900) {
            return (gender == 'm' ? 9 : 0);
        } else if (year >= 1900 && year < 2000) {
            return (gender == 'm' ? 1 : 2);
        } else { //  (year >= 2000 && year < 2100)
            return (gender == 'm' ? 3 : 4);
        }
    }

}
