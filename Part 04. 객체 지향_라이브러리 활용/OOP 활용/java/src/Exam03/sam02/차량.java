package Exam03.sam02;

public class 차량 {
    public String 이름 = "차량";
    public double 최대속도;
    public int 정원;

    public 차량() {
        System.out.println("차량의 생성자 호출!");
    }

    public 차량(double 최대속도, int 정원) {
        System.out.println("차량의 새성자(매개변수(최대속도, 정원))을 받는 호출!");
        this.최대속도 = 최대속도;
        this.정원 = 정원;
    }

    public void 정보출력() {
        System.out.println("이름: " + 이름);
        System.out.println("최대속도: " + 최대속도);
        System.out.println("정원: " + 정원);
    }

    public static void main(String[] args) {

    }
}
