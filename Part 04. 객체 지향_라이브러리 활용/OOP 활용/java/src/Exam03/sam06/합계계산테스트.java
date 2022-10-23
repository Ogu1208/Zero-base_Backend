package Exam03.sam06;

public class 합계계산테스트 {
    public static void main(String[] args) {
        합계계산 계산1 = new 합계계산();

        System.out.println(계산1.더하기(10, 20));
        System.out.println(계산1.더하기(10, 20, 30));
        System.out.println(계산1.더하기((new int[]{10, 20, 30, 40, 50}), 30));
    }
}
