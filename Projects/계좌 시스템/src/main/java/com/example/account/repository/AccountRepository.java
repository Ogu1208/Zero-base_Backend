package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // 형식에 맞춰 작성하면 자동으로 쿼리를 생성해준다.
    Optional<Account> findFirstByOrderByIdDesc();
}
