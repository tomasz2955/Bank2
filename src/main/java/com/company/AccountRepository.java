package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountRepository {
    List<Account> bankAccounts = new ArrayList<>();


    public void addNewAccount(Account account) {
        try {
            findAccount(account.getAccountName());
            System.out.println("account already exists");
        } catch (RuntimeException exception) {
            bankAccounts.add(account);
        }
    }

    public void removeExistingAccount(String removeAccountName) {
        try {
            findAccount(removeAccountName);
            this.bankAccounts = bankAccounts.stream().filter(acc->!acc.getAccountName().equals(removeAccountName)).collect(Collectors.toList());
        } catch (RuntimeException exception) {
            System.out.println("Account not found");
        }
    }

    public Account findAccount(String accountName) {
        return bankAccounts.stream().filter(acc -> acc.getAccountName().equals(accountName)).findAny().orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
