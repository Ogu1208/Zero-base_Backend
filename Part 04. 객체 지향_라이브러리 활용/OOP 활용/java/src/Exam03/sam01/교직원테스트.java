package Exam03.sam01;

public class 교직원테스트 {
    public static void main(String[] args) {
        교직원 김사랑 = new 교직원("김사랑", 1111, "패스트캠퍼스", 2222);


        System.out.println("==================");
        System.out.println("이름:" + 김사랑.이름);
        System.out.println("주민번호: " + 김사랑.get주민번호());
        System.out.println("학교명: " + 김사랑.학교명);
        System.out.println("교원번호: " + 김사랑.get교직원번호());


        System.out.println("==================");
        사람 사람1 = 김사랑;

        System.out.println("이름: " + 사람1.이름);
        System.out.println("주민번호: " + 사람1.번호);

    }
}
