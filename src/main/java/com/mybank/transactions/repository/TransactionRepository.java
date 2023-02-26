package com.mybank.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.transactions.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
