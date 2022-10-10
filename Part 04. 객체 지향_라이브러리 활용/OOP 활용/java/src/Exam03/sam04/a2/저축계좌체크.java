package Exam03.sam04.a2;

import Exam03.sam04.a1.계좌;

import java.util.Calendar;

public class 저축계좌체크 extends 계좌 {

    public void 값체크() {
        이름 = "저축계좌";
        개설일 = Calendar.getInstance().getTime();

    }
}
