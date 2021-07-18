package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepository {
    List<Account> bankAccounts = new ArrayList<>();

    public void addNewAccount(Account account) {
        if(findAccount(account.getAccountName()) == null)
            bankAccounts.add(account);
    }

    public void removeExistingAccount(String removeAccountName) {
        List<Account> filteredList = bankAccounts.stream().filter(acc->!acc.getAccountName().equals(removeAccountName)).collect(Collectors.toList());
        bankAccounts = filteredList;
    }

    public Account findAccount(String accountName) {
        return bankAccounts.stream().filter(acc -> acc.getAccountName().equals(accountName)).findAny().orElse(null);
    }
}