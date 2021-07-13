package com.company;

import java.util.stream.IntStream;

public class AccountStatisticsService {

    private final AccountRepository repository;

    public AccountStatisticsService(AccountRepository repository) {
        this.repository = repository;
    }

    public void sumAccount() {
        double totalSum = 0;

        //foreach
//        for(Account account: repository.bankAccounts) {
//
//        }

        for (int i = 0; i < repository.bankAccounts.size(); i++) {
            totalSum += repository.bankAccounts.get(i).getBalance(); //bez gettera nie możnu;

        }
//                                        [acc1, acc2, acc3]                            [123, 33, 324]
//        repository.bankAccounts.stream().mapToDouble(account -> account.getBalance()).sum();
//lepiej lepiej        repository.bankAccounts.stream().mapToDouble(Account::getBalance).sum();

        System.out.println("The total sum of all funds in the accounts: " + totalSum);
    }

    public void numberOfAccounts() {
        System.out.println("Total number of bank accounts: " + repository.bankAccounts.size());
    }
}
