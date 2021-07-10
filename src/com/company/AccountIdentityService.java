package com.company;

public class AccountIdentityService {

    AccountRepository accountRepository;

    public AccountIdentityService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public boolean updateAccount(Account acc1, Account acc2) {
        int foundPosition = accountRepository.findAccount(acc1.getName());
        if(foundPosition<0) {
            System.out.println(acc1.getName() + " was not found");
            return false;
        }
        this.accountRepository.bankAccounts.set(foundPosition, acc2);
        System.out.println(acc1.getName() + " was replaced with " + acc2.getName());
        return true;
    }



}