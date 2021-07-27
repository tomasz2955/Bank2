package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountRepository {
    private List<Account> bankAccounts = new ArrayList<>();

    public void addNewAccount(Account account) {
        try {
            findAccount(account.getAccountName());
            System.out.println("account already exists");
        } catch (RuntimeException exception) {
            bankAccounts.add(account);
        }
    }

    //boolean
    public void removeExistingAccount(String removeAccountName) {
            findAccount(removeAccountName);
            this.bankAccounts = bankAccounts.stream().filter(acc->!acc.getAccountName().equals(removeAccountName)).collect(Collectors.toList());
    }

    public Account findAccount(String accountName) {
        return bankAccounts.stream()
                .filter(acc -> acc.getAccountName().equals(accountName))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Account" + accountName + "not found"));
    }
//
//    public boolean accountExists(String accountName) {
//        return bankAccounts.stream()
//                .filter(acc -> acc.getAccountName().equals(accountName))
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//    }


    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
