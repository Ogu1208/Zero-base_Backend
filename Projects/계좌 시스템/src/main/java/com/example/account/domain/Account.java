package com.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity  // 설정 클래스
public class Account {
    @Id
    @GeneratedValue
    private Long id;   // Account table에 pk로 id를 지정

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
