package com.mybank.transactions.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mybank.transactions.model.Account;
import com.mybank.transactions.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {
  private AccountRepository accountRepository;

  public Account createAccount(Account account) {
    return accountRepository.save(account);
  }

  public void deleteAccount(Long id) {
    accountRepository.deleteById(id);
  }

  public Optional<Account> getAccountById(Long id) {
    return accountRepository.findById(id);
  }

  public void updateAccount(Long id, Account account) {
    Optional<Account> accountOpt = accountRepository.findById(id);
    if (accountOpt.isPresent()) {
      Account existingAccount = accountOpt.get();
      existingAccount.setName(account.getName());
      existingAccount.setCpf(account.getCpf());
      existingAccount.setInstitution(account.getInstitution());
      existingAccount.setType(account.getType());
      accountRepository.save(existingAccount);
    }
  }
}
