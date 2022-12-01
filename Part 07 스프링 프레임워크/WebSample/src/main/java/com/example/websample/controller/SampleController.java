package com.example.websample.controller;

import com.example.websample.dto.ErrorResponse;
import com.example.websample.exception.ErrorCode;
import com.example.websample.exception.WebSampleException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j   // lombok 라이브러리
@RestController
public class SampleController {

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        log.info("Get some order : " + id);   // log는 Slf4j에 속함

        if ("500".equals(id)) {
            throw new WebSampleException(
                    ErrorCode.TOO_BIG_ID_ERROR,
                    "500 is too big orderId.");
        }

        if ("3".equals(id)) {
            throw new WebSampleException(
                    ErrorCode.TOO_SMALL_ID_ERROR,
                    "500 is too small orderId.");
        }

        if ("4".equals(id)) {
            // DB에 중복된 데이터가 insert 시도를 했을 때
            throw new SQLIntegrityConstraintViolationException(
                    "Duplicated insertion was tried");
        }

        return "orderId:" + id + ", " + "orderAmount:1000";
    }

//    @ResponseStatus(HttpStatus.FORBIDDEN)



    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id) {
        log.info("Delete some order : " + id);   // log는 Slf4j에 속함
        return "Delete orderId:" + id;
    }

    @GetMapping("/order")
    public String getOrderWithRequestParam(
            @RequestParam(value = "orderId", required = false, defaultValue = "defaultId") String id,
            @RequestParam("orderAmount") Integer amount) {
        log.info("Get order : " + id + ", amount : " + amount);
        return "orderId:" + id + ", " + "orderAmount:" + amount;
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader String userAccountId) {
        log.info("Create order : " + createOrderRequest +
                ", userAccountId : " + userAccountId);
        return "orderId:" + createOrderRequest.getOrderId() + ", " +
                "orderAmount:" + createOrderRequest.getOrderAmount();
    }

    @PutMapping("/order")
    public String createOrder() {
        log.info("Create some order");
        return "order created -> orderId:1, orderAmount:1000";
    }

    @Data    // lombok - getter/setter/생성자를 줄여줌
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;
    }
}
