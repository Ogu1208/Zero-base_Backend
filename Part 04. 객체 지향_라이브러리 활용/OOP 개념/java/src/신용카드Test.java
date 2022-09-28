public class 신용카드Test {
    public static void main(String[] args) {
        신용카드 내카드 = new 신용카드();
        내카드.카드번호 = 1111_2222_3333_4444L;
        내카드.카드소유주 = "홍길동";


        System.out.println(내카드.카드번호);
        System.out.println(내카드.카드소유주);
        System.out.println(내카드.카드사용누적금액);
        System.out.println(내카드.누적포인트);

        내카드.카드사용(8000);
        내카드.카드사용(12000);
        내카드.카드사용(21000);
        내카드.카드비용지급(30000);

        System.out.println(내카드.카드번호);
        System.out.println(내카드.카드소유주);
        System.out.println(내카드.카드사용누적금액);
        System.out.println(내카드.누적포인트);
    }
}
