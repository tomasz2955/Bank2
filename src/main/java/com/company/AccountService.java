package com.company;

public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void deposit(String accountName, double depositValue) {
        try {
            Account account = repository.findAccount(accountName);
            account.deposit(depositValue);
        } catch (RuntimeException exception) {
            System.out.println("Account not found");
        }
    }

    public void withdraw(String accountName, double withdrawValue) {
        try {
            Account account = repository.findAccount(accountName);
            account.withdraw(withdrawValue);
        } catch (RuntimeException exception) {
            System.out.println("Account not found");
        }
    }

    public void transfer(String withdrawAccountName, String depositAccountName, double transferValue) {
        try {
        Account withdrawAccount = repository.findAccount(withdrawAccountName);
        Account depositAccount = repository.findAccount(depositAccountName);
            withdrawAccount.withdraw(transferValue);
            depositAccount.deposit(transferValue);
        } catch (RuntimeException exception) {
            System.out.println("Account not found");
        }
    }

}
