package Exam03.sam01;

public class 다운캐스팅테스트 {
    public static void main(String[] args) {

        /*
        사람 남자 = new 사람("홍길동", 11111);
        System.out.println("이름: " + 남자.이름 + ", 주민번호: " + 남자.번호);

        교직원 교직원1 = 남자;  // 컴파일 오류
        교직원 교직원2 = (교직원) 남자;

        System.out.println("학교명: " + 교직원2.학교명);
         */


        교직원 남자교직원 = new 교직원("홍길동", 1111, "패스트캠퍼스", 22222);

        System.out.println("-----------------------");
        System.out.println("이름: " + 남자교직원.이름 + "주민번호: " + ((사람)남자교직원).번호);
        System.out.println("학교명: " + 남자교직원.학교명 + ", 교직원번호: " + 남자교직원.번호);

        사람 남자사람 = 남자교직원;

        System.out.println("-----------------------");
        System.out.println("이름: " + 남자사람.이름 + ", 주민번호: " + 남자사람.번호);

        교직원 남자교직원2 = (교직원)남자사람;
        System.out.println("이름: " + 남자교직원2.이름 + "주민번호: " + ((사람)남자교직원2).번호);
        System.out.println("학교명: " + 남자교직원2.학교명 + ", 교직원번호: " + 남자교직원2.번호);
    }
}
