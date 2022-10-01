public class 달력테스트 {

    public static void main(String[] args) {
        달력 내달력 = new 달력(31);
//        내달력.lastMonth = 13;

        System.out.println(내달력.LAST_MONTH);

        System.out.println(내달력.LAST_DATE);  // 클래스로 바로 접근
    }
}
