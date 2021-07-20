package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountRepository {
    private List<Account> bankAccounts = new ArrayList<>();

    public void addNewAccount(Account account) {
        if(findAccount(account.getAccountName()) == null)
            bankAccounts.add(account);
    }

    public void removeExistingAccount(String removeAccountName) {
        List<Account> filteredList = bankAccounts.stream().filter(acc->!acc.getAccountName().equals(removeAccountName)).collect(Collectors.toList());
        bankAccounts = filteredList;
        //łatwiej
        // this.bankAccounts = bankAccounts.stream().filter(acc->!acc.getAccountName().equals(removeAccountName)).collect(Collectors.toList());

    }

    public Account findAccount(String accountName) {
        return bankAccounts.stream().filter(acc -> acc.getAccountName().equals(accountName)).findAny().orElse(null);
        //tu zastosowałbym orelseTHrow zeby rzucić wyjątkiem jak konta nie ma, to będzie dobry case do testu
//        return bankAccounts.stream().filter(acc -> acc.getAccountName().equals(accountName)).findAny().orElseThrow(() -> new RuntimeException("Account not found"));

        //albo jeszcze lepiej zwróć optionala czyli
//        Optional<Account> any = bankAccounts.stream().filter(acc -> acc.getAccountName().equals(accountName)).findAny();
        // i takiego optionala przekaż do service
    }
}
