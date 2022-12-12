package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Client <-> Controller 통신
public class AccountInfo {
    private String accountNumber;
    private Long balance;
}
