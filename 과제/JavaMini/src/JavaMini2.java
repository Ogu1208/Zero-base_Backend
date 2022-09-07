/*
    이름 : 김민아
    과제 : 미니과제 02. '결제 금액 캐시백 계산 프로그램'
*/


import java.util.Scanner;

public class JavaMini2 {
    public static void main(String[] args) {
        int cash;
        int price;
        Scanner sc = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해주세요.(금액): ");
        price = sc.nextInt();

        cash = cashBack(price);
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", price, cash);

    }

    public static int cashBack(int price) {
        double result = price * 0.1;
        if (result >= 300) {
            return 300;
        } else if (result >= 200) {
            return 200;
        } else if (result >= 100) {
            return 100;
        } else
            return 0;
    }

}
