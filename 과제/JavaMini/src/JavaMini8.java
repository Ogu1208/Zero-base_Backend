/*
    이름 : 김민아
    과제 : 미니과제 08. '연소득 과세금액 계산 프로그램'
*/


import java.util.Scanner;

public class JavaMini8 {
    static long[] taxRange = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
    static long[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};
    static long[] deduction = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
    static int idx = 0;


    // 누진공제 계산에 의한 세금
    public static long calDecRate(long inCome, int taxIdx) {
        long result = (inCome * taxRate[taxIdx] / 100) - deduction[taxIdx];
        return result;
    }


    // 세율에 의한 세금
    public static long byTaxRate(long inCome) {

        long taxResult = 0;
        while (true) {
            // 10억 초과분
            if (idx == 7) {
                long tmp = (inCome - taxRange[idx]) * taxRate[idx] / 100;
                taxResult += tmp;
                System.out.printf("%12d * %2d%% = %10d\n", inCome - taxRange[idx], taxRate[idx], tmp);
                break;
            }

            // 10억 이하
            if (inCome > taxRange[idx + 1]) {
                long tmp = (taxRange[idx + 1] - taxRange[idx]) * taxRate[idx] / 100;
                taxResult += tmp;
                System.out.printf("%12d * %2d%% = %10d\n", taxRange[idx + 1] - taxRange[idx], taxRate[idx], tmp);
                idx++;
            } else {
                long tmp = (inCome - taxRange[idx]) * taxRate[idx] / 100;
                taxResult += tmp;
                System.out.printf("%12d * %2d%% = %10d\n", inCome - taxRange[idx], taxRate[idx], tmp);
                break;
            }
        }
        return taxResult;
    }

    // 연소득 입력받기
    public static long prompt() {
        long inCome;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[과세 금액 계산 프로그램]");
            System.out.print("연소득을 입력해 주세요.: ");
            inCome = sc.nextLong();

            if (inCome < 0) {
                System.out.println("0원보다 커야 합니다. 다시 입력하세요.");
                continue;
            }
            break;
        }

        return inCome;
    }

    public static void main(String[] args) {

        long inCome = prompt();

        System.out.println();
        System.out.printf("[세율에 의한 세금]:  \t\t\t %d\n", byTaxRate(inCome));
        System.out.printf("[누진공제 계산에 의한 세금]: \t %d\n", calDecRate(inCome, idx));
    }
}
