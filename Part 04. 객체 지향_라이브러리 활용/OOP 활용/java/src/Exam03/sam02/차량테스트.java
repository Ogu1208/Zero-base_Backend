package Exam03.sam02;

public class 차량테스트 {

    public static void main(String[] args) {
        System.out.println("차턍테스트!");

        차량 차량1 = new 차량();
        차량1.이름 = "차량";
        차량1.최대속도 = 100;
        차량1.정원 = 2;

        차량1.정보출력();
    }
}
