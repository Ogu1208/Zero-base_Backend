package Exam03.sam02;

public class 자동차테스트 {

    public static void main(String[] args) {
        자동차 자동차1 = new 자동차();
//        자동차1.이름 = "차량";
//        자동차1.최대속도 = 100;
//        자동차1.정원 = 2;
//        자동차1.배기량 = "2000cc";
//        자동차1.정보출력();

        자동차 자동차2 = new 자동차(200, 4, "2000cc");
        자동차2.정보출력();
    }

}
