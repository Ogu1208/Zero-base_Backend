package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import com.zerobase.convpay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
//@ComponentScan(basePackages = "com.zerobase.convpay")
@ComponentScan(basePackageClasses = ConvpayApplication.class)
public class ApplicationConfig {
    @Autowired
    private ApplicationContext applicationContext;

    private void getResource() throws IOException {
        Resource resource = applicationContext.getResource("myTemplate.txt");

        System.out.println(resource.contentLength() + "");

    }


//    @Bean
//    public ConveniencePayService conveniencePayService(){
//        return new ConveniencePayService(
//                new HashSet<>(Arrays.asList(moneyAdapter(), cardAdapter())),
//                discountByConvenience()
//        );
//    }
//    @Bean
//    public CardAdapter cardAdapter() {
//        return new CardAdapter();
//    }
//    @Bean
//    public MoneyAdapter moneyAdapter() {
//        return new MoneyAdapter();
//    }
//    @Bean
//    public DiscountByConvenience discountByConvenience() {
//        return new DiscountByConvenience();
//    }


}
