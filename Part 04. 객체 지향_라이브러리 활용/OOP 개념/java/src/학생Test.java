public class 학생Test {
    public static void main(String[] args) {
        학생 공부하는학생 = new 학생("박하은");  // 기본생성자

        System.out.println(공부하는학생.이름);

        학생 조는학생 = new 학생();
        조는학생.이름 = "박하영";

        System.out.println(조는학생.이름);
    }
}
