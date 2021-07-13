package com.company;

public class AccountService {

    private final AccountRepository repository;

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

    public void transfer(String name1, String name2, double value) { //sensowniejsze zmienne
        Account account1 = repository.queryAccount(name1);
        Account account2 = repository.queryAccount(name2);
        if (account1.getBalance() < value) { //a jak zrobie transfer minusowej liczby - TESTY
            System.out.println("You can't transfer money, not enough funds");
        } else {
            account1.withdraw(value);
            account2.deposit(value);
            System.out.println("Transfer completed");
        }
    }

}
