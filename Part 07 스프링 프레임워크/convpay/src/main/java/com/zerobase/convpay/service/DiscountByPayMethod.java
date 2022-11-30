package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class DiscountByPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        System.out.println("DiscountByPayMethod called");
        switch (payRequest.getPayMethodType()) {
            case MONEY:
                return payRequest.getPayAmount() * 7 / 10;
            case CARD:
                return payRequest.getPayAmount();
        }

        return payRequest.getPayAmount();
    }
}
