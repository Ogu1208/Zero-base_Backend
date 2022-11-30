package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Profile("test")
public class DiscountByConvenience implements DiscountInterface{
    // 편의점 할인
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        System.out.println("DiscountByConvenience called");
        switch (payRequest.getConvenienceType()) {
            case G25:   // 20% 할인
                return payRequest.getPayAmount() * 8 / 10;
            case GU:    // 10% 할인
                return payRequest.getPayAmount() * 9 / 10;
            case SEVEN: // 할인 없음
                return payRequest.getPayAmount();
        }

        return payRequest.getPayAmount();
    }
}
