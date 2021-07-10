package com.company;

public class AccountStatisticsService {

    private AccountRepository repository;

    public AccountStatisticsService(AccountRepository repository) {
        this.repository = repository;
    }

    public void sumAccount() {
        double totalSum = 0;

        for (int i = 0; i < repository.bankAccounts.size(); i++) {
            double sum = repository.bankAccounts.get(i).getBalance();
            totalSum += sum;

        }
        System.out.println("The total sum of all funds in the accounts: " + totalSum);
    }

    public void numberOfAccounts() {
        System.out.println("Total number of bank accounts: " + repository.bankAccounts.size());
    }
}
