package com.company;


public class AccountStatisticsService {

    private final AccountRepository repository;

    public AccountStatisticsService(AccountRepository repository) {
        this.repository = repository;
    }

    public void sumAccountMoney() {
        double totalSum = 0;
        for (Account account : repository.bankAccounts) {
            totalSum += account.getAccountBalance();
        }
        System.out.println(totalSum);
    }

    public long numberOfAccounts() {
        return repository.bankAccounts.size();
    }

    public void listOfAccounts() {
        for(Account account : repository.bankAccounts) {
            System.out.println(account);
        }
        //prościej streamem
//        repository.bankAccounts.forEach(System.out::println);
    }

}
