package Exam03.sam04.a1;

import java.util.Calendar;

public class 저축계좌 extends 계좌{
    public void 값설정() {
        이름 = "은행계좌";
        개설일 = Calendar.getInstance().getTime();
        계좌번호 = 12345;
//        super.금액 = 1000;  // private -> x

    }
}
