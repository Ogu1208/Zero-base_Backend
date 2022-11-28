package com.zerobase.convpay;

import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {
        // `사용자` -> 편결이 -> 머니

        // 편결이 불러오기
        ApplicationConfig applicationConfig = new ApplicationConfig();
//        ConveniencePayService conveniencePayService = new ConveniencePayService();
        ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountPayMethod();


        // 1. 현금, G25, 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse); // 객체의 toString이 불러짐


        // 2. 카드, G25, 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);

    }
}
