package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class AccountIdentityService {

    AccountRepository accountRepository;

    public AccountIdentityService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public boolean updateAccount(Account existing, Account newAcc) {
        int foundPosition = accountRepository.findAccount(existing.getName());
        if(foundPosition<0) { //nieeeee
            System.out.println(existing.getName() + " was not found");
            return false;
        }


//        List<Account> filteredList = accountRepository.bankAccounts.stream()
//                .filter(acc -> !acc.getName().equals(existing.getName()))
//                .collect(Collectors.toList());
//
//        filteredList.add(newAcc);

        this.accountRepository.bankAccounts.set(foundPosition, newAcc);
        System.out.println(existing.getName() + " was replaced with " + newAcc.getName());
        return true;
    }



}
