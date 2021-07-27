package com.company;
import java.util.Scanner;

// o streamach lambdach itp https://www.youtube.com/watch?v=gpIUfj3KaOc&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=1
// maven
// testy

public class Main {

    private static final AccountRepository accountRepository = new AccountRepository();
    private static final AccountStatisticsService accountStatisticsService = new AccountStatisticsService(accountRepository);
    private static final AccountService accountService = new AccountService(accountRepository);
    private static final AccountIdentityService accountIdentityService = new AccountIdentityService(accountRepository);
    private Account account;


    public static void main(String[] args) {

        accountRepository.addNewAccount(new Account("Tomek", 200));
        accountRepository.addNewAccount(new Account("Kamil", 207));
        accountStatisticsService.listOfAccounts();
        accountIdentityService.updateExistingAccount("Kamil", new Account("Patryk", 700));


        accountStatisticsService.listOfAccounts();

    }
}