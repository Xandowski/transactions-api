package com.mybank.transactions.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mybank.transactions.model.Account;
import com.mybank.transactions.model.Transaction;
import com.mybank.transactions.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

  private TransactionRepository transactionRepository;
  private AccountService accountService;

  public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
  }

  public Optional<Transaction> getTransactionById(Long id) {
    return transactionRepository.findById(id);
  }

  public Transaction createTransaction(Transaction transaction) {
    Account destinationAccount = accountService.getAccountById(transaction.getDestination().getId()).orElse(null);
    transaction.setDestination(destinationAccount);
    transaction.setDate(LocalDateTime.now());

    Transaction newTransaction = transactionRepository.save(transaction);
    newTransaction.getDestination().setName(destinationAccount.getName());
    newTransaction.getDestination().setCpf(destinationAccount.getCpf());
    newTransaction.getDestination().setInstitution(destinationAccount.getInstitution());
    newTransaction.getDestination().setType(destinationAccount.getType());

    return newTransaction;
  }

  public void deleteTransaction(Long id) {
    transactionRepository.deleteById(id);
  }

  public void updateTransaction(Long id, Transaction transaction) {
    Optional<Transaction> transactionOpt = transactionRepository.findById(id);
    if (transactionOpt.isPresent()) {
      Transaction existingTransaction = transactionOpt.get();
      existingTransaction.setName(transaction.getName());
      existingTransaction.setAmount(transaction.getAmount());
      existingTransaction.setDate(transaction.getDate());
      existingTransaction.setDestination(transaction.getDestination());
      transactionRepository.save(existingTransaction);
    }
  }
}
