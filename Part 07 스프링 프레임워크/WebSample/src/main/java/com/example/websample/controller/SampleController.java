package com.example.websample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j   // lombok 라이브러리
@RestController
public class SampleController {

    @GetMapping("/order/1")
    public String getOrder() {
        log.info("Get some order");   // log는 Slf4j에 속함
        return "orderId:1, orderAmount:1000";
    }

    @PostMapping("/order")
    public String createOrder() {
        log.info("Create some order");   // log는 Slf4j에 속함
        return "order created -> orderId:1, orderAmount:1000";
    }
}
