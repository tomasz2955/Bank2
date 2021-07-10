package com.company;

public class AccountService {

    private AccountRepository repository;
    public AccountService(AccountRepository repository) {

        this.repository = repository;
    }


    public void deposit(String name, double value) {
        Account account = repository.queryAccount(name);
        account.deposit(value);
    }

    public void withdraw(String name, double value) {
        Account account = repository.queryAccount(name);
        account.withdraw(value);
    }







    public void transfer(String accNum1, String accNum2, double value) {

    }

}
