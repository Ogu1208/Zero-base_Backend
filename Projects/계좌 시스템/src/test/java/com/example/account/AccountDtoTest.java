package com.example.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AccountDtoTest {

    @Test
    void accountDto() {
        // given
        // when
        // then

        AccountDto accountDto = new AccountDto(
                "accountNumber",
                "winter",
                LocalDateTime.now());

        System.out.println(accountDto.toString());
        accountDto.log();
    }


}