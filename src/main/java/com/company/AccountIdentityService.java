package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class AccountIdentityService {
    private AccountRepository accountRepository;

    public AccountIdentityService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public void updateExistingAccount(String existingAccountName, Account accountAfterUpdate) {
        accountRepository.findAccount(existingAccountName);
//        accountRepository.bankAccounts = accountRepository.bankAccounts.stream().
//                filter(acc -> !acc.getAccountName().equals(existingAccountName)).collect(Collectors.toList());;
//        accountRepository.bankAccounts.add(accountAfterUpdate);

//        accountRepository.setBankAccounts()
        accountRepository.bankAccounts = accountRepository.bankAccounts.stream()
                .map(account -> account.getAccountName().equals(existingAccountName) ? accountAfterUpdate : account)
                .collect(Collectors.toList());


        //ta linijka z map to jest taka inna forma ifa: jezeli znajdziesz account o danym imieniu to zastąp go nowym
        // a jezeli nie to po prostu przekaż w streamie niezmienialny obiekt dalej
        // http://www.cafeaulait.org/course/week2/43.html
    }


    // accountRepository.bankAccounts.stream()
    // .map(account -> account.getAccountName().equals(existingAccountName) ? accountAfterUpdate: account)
    // .collect(Collectors.toList());


}
