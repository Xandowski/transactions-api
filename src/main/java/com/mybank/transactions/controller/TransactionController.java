package com.mybank.transactions.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.transactions.model.Account;
import com.mybank.transactions.model.Transaction;
import com.mybank.transactions.service.AccountService;
import com.mybank.transactions.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

  private TransactionService transactionService;
  private AccountService accountService;

  @GetMapping
  public ResponseEntity<List<Transaction>> getAllTransactions() {
    List<Transaction> transactions = transactionService.getAllTransactions();
    return new ResponseEntity<>(transactions, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
    Optional<Transaction> transaction = transactionService.getTransactionById(id);
    if (transaction.isPresent()) {
      return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
    Account destinationAccount = accountService.getAccountById(transaction.getDestination().getId()).orElse(null);
    transaction.setDestination(destinationAccount);
    Transaction newTransaction = transactionService.createTransaction(transaction);

    return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
    transactionService.deleteTransaction(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
    transactionService.updateTransaction(id, transaction);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
