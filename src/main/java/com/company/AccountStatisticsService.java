package com.company;


public class AccountStatisticsService {

    private final AccountRepository repository;

    public AccountStatisticsService(AccountRepository repository) {
        this.repository = repository;
    }

    public double sumAccountMoney() {
        double totalSum = 0;
        for (Account account : repository.getBankAccounts()) {
            totalSum += account.getAccountBalance();
        }
        return totalSum;
    }

    public long numberOfAccounts() {
        return repository.bankAccounts.size();
    }

    public void listOfAccounts() {
        repository.bankAccounts.forEach(System.out::println);
    }

}
