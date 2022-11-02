package Exam03.sam01;

public class 사람 {
    public String 이름;
    public long 번호; // 주민번호

    public 사람() {

    }

    public 사람(String 이름, long 번호) {
        this.이름 = 이름;
        this.번호 = 번호;
    }

    public long get주민번호() {
        return 번호;
    }

    public void 정보출력() {
        System.out.println("[사람정보] ===============");
        System.out.println("이름: " + 이름);
        System.out.println("주민번호: " + 번호);
    }
}
