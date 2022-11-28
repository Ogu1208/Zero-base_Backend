package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;

public class CardAdapter {
    // 1. 인증
    public void authorization() {
        System.out.println("authorization success.");
    }

    // 2. 승인
    public void approval() {
        System.out.println("approval success");
    }

    // 3. 매입
    public CardUseResult capture(Integer payAmount) {

        // fail case
        if (payAmount > 100) {
            return CardUseResult.USE_FAIL;
        }

        // success
        return CardUseResult.USE_SUCCESS;
    }
    // 4. 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {

        // fail- case 카드 취소 금액이 너무 작을 경우
        if(cancelAmount < 1000) {
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }

        // success case
        return CardUseCancelResult.USE_CANCEL_SUCCESS;

    }

}
