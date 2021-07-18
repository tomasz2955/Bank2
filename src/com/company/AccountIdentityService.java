package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class AccountIdentityService {
    AccountRepository accountRepository;

    public AccountIdentityService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public void updateExistingAccount(String existingAccountName, Account accountAfterUpdate) {
        List<Account> filteredListAfterUpdate = accountRepository.bankAccounts.stream().
                filter(acc->!acc.getAccountName().equals(existingAccountName)).collect(Collectors.toList());
        accountRepository.bankAccounts = filteredListAfterUpdate;
        accountRepository.bankAccounts.add(accountAfterUpdate);
    }



}