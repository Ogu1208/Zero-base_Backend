import java.util.Scanner;

public class Assignment08 {
    public static final long[] IncomeRange = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
    public static final long[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};
    public static final long[] deductions = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

    // 누진공제 계산에 의한 세금
    public static long calDeduction(long annualIncome, int idx) {
        long deduction = (annualIncome * taxRate[idx] / 100) - deductions[idx] ;

        return deduction;
    };

    public static long prompt(){
        long annualIncome;
        Scanner kb = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        while (true) {
            System.out.print("연소득을 입력해 주세요. : ");
            annualIncome = kb.nextInt();

            if(annualIncome < 0) {
                System.out.println("입력이 잘못되었습니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }

        return annualIncome;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        long annualIncome = prompt();

        int idx = 0;        // 구간 인덱스
        int tax = 0;        // 세금

        while(true) {
            if(idx>=7) {        // 10억 초과 분 세금
                long tmp = (annualIncome - IncomeRange[idx])  * taxRate[idx] / 100;
                System.out.printf("%,15d * %2d%% = %,12d \n", (annualIncome - IncomeRange[idx]), taxRate[idx], tmp);
                tax += tmp;
                break;
            }

            // 10억 이하까지의 세금
            if(annualIncome > IncomeRange[idx+1]) {
                long tmp = (IncomeRange[idx+1] - IncomeRange[idx]) * taxRate[idx] / 100 ;
                System.out.printf("%,15d * %2d%% = %,12d \n", (IncomeRange[idx+1] - IncomeRange[idx]), taxRate[idx], tmp);
                tax += tmp;
                idx++;
            } else {
                long tmp = (annualIncome - IncomeRange[idx])  * taxRate[idx] / 100;
                System.out.printf("%,15d * %2d%% = %,12d \n", (annualIncome - IncomeRange[idx]), taxRate[idx], tmp);
                tax += tmp;
                break;
            }
        }

        System.out.println();
        System.out.printf("[세율에 의한 세금] : \t\t\t %,10d원 \n", tax);
        System.out.printf("[누진공제 계산에 의한 세금] : \t %,10d원 \n", calDeduction(annualIncome, idx));

    }
}