package com.mybank.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.transactions.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
