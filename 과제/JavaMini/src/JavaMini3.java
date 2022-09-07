/*
    이름 : 김민아
    과제 : 미니과제 03. '놀이동산 입장권 계산 프로그램'
*/


import java.util.Scanner;

public class JavaMini3 {
    public static void main(String[] args) {
        int age;
        int admission;
        char nationalMerit;
        char welfareCard;
        int price;
        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자): ");
        age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요.(숫자입력): ");
        admission = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n): ");
        nationalMerit = sc.next().charAt(0);
        System.out.print("복지카드 여부를 입력해 주세요.(y/n): ");
        welfareCard = sc.next().charAt(0);

        price = caculateAdmission(age, admission, nationalMerit, welfareCard);
        System.out.println("입장료: " + price);
    }

    public static int caculateAdmission(int age, int admission, char nationalMerit, char welfareCard) {
        int basicAdmission = 10000;
        int specialDsc = 4000;
        int generalDsc = 8000;

        if (age < 3) {
            return 0;
        } else if (age < 13) {
            return specialDsc;
        } else if (admission >= 17) {
            return specialDsc;
        } else if (nationalMerit == 'y' || welfareCard == 'y') {
            return generalDsc;
        } else {
            return basicAdmission;
        }
    }
}
