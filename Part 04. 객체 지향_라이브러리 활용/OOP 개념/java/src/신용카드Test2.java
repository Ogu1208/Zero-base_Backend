public class 신용카드Test2 {
    public static void main(String[] args) {
        신용카드 내카드 = new 신용카드();
        내카드.카드번호 = 1111_2222_3333_4444L;
        내카드.카드소유주 = "홍길동";

        신용카드 내다른카드 = new 신용카드();
        내다른카드.카드번호 = 2222_3333_4444_5555L;
        내다른카드.카드소유주 = "Ogu";

        내카드.카드사용(12000);
        내다른카드.카드사용(25000);

        System.out.println(내카드.카드번호);
        System.out.println(내카드.카드소유주);
        System.out.println(내카드.카드사용누적금액);
        System.out.println(내카드.누적포인트);

        System.out.println(내다른카드.카드번호);
        System.out.println(내다른카드.카드소유주);
        System.out.println(내다른카드.카드사용누적금액);
        System.out.println(내다른카드.누적포인트);
    }
}
