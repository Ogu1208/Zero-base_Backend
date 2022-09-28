public class CreditCardTest {
    public static void main(String[] args) {
        CreditCard myCard = new CreditCard();
//        myCard.setCardNumber(1234_5678_1234_5678L);
        myCard.setCardNumber(234_5678_1234_5678L);
        myCard.cardOwner = "홍길동";

        System.out.println(myCard.getCardNumber());
        System.out.println(myCard.cardOwner);
        System.out.println(myCard.balance);
        System.out.println(myCard.point);

        myCard.use(8000);
        myCard.use(12000);
        myCard.use(21000);
        myCard.payBill(30000);

        System.out.println();
        System.out.println("----------------");
        System.out.println(myCard.getCardNumber());
        System.out.println(myCard.cardOwner);
        System.out.println(myCard.balance);
        System.out.println(myCard.point);

    }
}
