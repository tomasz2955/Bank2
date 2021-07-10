package com.company;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountRepository accountRepository = new AccountRepository("123");
    private static final AccountStatisticsService accountStatisticsService = new AccountStatisticsService(accountRepository);
    private static final AccountService accountService = new AccountService(accountRepository);
    private static final AccountIdentityService accountIdentityService = new AccountIdentityService(accountRepository);

    public static void main(String[] args) {

        boolean quit = false;
        startBank();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action:");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0 -> {
                    System.out.println("\nYou have been logged out");
                    quit = true;
                }
                case 1 -> addNewAccount();
                case 2 -> updateAccount();
                case 3 -> removeAccount();
                case 4 -> accountRepository.printContacts();
                case 5 -> queryAccount();
                case 6 -> deposit();
                case 7 -> withdraw();
                case 9 -> accountStatisticsService.sumAccount();
                case 10 -> accountStatisticsService.numberOfAccounts();
                case 11 -> printActions();
            }
        }

    }
    private static void startBank() {
        System.out.println("You logged into the bank");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to exit");
        System.out.println("1 - to add new account");
        System.out.println("2 - to update an existing account");
        System.out.println("3 - to remove an existing account");
        System.out.println("4 - to display the account list");
        System.out.println("5 - query if an existing account exists");
        System.out.println("6 - to deposit new funds");
        System.out.println("7 - to withdraw funds");
        System.out.println("8 - to transfer funds");
        System.out.println("9 - to see the sum of funds in all accounts");
        System.out.println("10 - to see number od accounts");
        System.out.println("11 - to print list of action");
        System.out.println("Choose your action: ");
    }

    private static void addNewAccount() {
        System.out.println("Enter new account name");
        String name = scanner.nextLine();
        System.out.println("Enter the opening balance");
        double balance = scanner.nextDouble();
        Account newAccount = Account.createAccount(name, balance);
        if(accountRepository.addNewAccount(newAccount)) {
            System.out.println("New account added: name = " + name + "; account number = " + newAccount.getAccountNumber() + "; balance = " + balance + ";");
        } else {
            System.out.println("Cannot add " + name + " already in file");
        }
    }

    private static void deposit() {
        System.out.println("Enter the name of account");
        String name = scanner.nextLine();
        System.out.println("Enter the amount");
        double cash = scanner.nextDouble();
        Account existingAccountRecord = accountRepository.queryAccount(name);
        if (existingAccountRecord == null) {
            System.out.println("Account not found");
        } else {
            accountService.deposit(name, cash);

        }
    }

    private static void withdraw() {
        System.out.println("Enter the name of account");
        String name = scanner.nextLine();
        System.out.println("Enter the amount");
        double cash = scanner.nextDouble();
        Account existingAccountRecord = accountRepository.queryAccount(name);
        if (existingAccountRecord == null) {
            System.out.println("Account not found");
        } else {
            accountService.withdraw(name, cash);

        }
    }

    private static void queryAccount() {
        System.out.println("Enter the name of an existing account");
        String name = scanner.nextLine();
        Account existingAccountRecord = accountRepository.queryAccount(name);
        if (existingAccountRecord == null) {
            System.out.println("Account not found");
            return;
        }
        System.out.println("Name: " + existingAccountRecord.getName() + ", Account number: " + existingAccountRecord.getAccountNumber() + ", Balance: " + existingAccountRecord.getBalance());

    }

    private static void removeAccount() {
        System.out.println("Enter the name of an existing account");
        String name = scanner.nextLine();
        Account existingAccountRecord = accountRepository.queryAccount(name);
        if (existingAccountRecord == null) {
            System.out.println("Account not found");
            return;
        }
        if (accountRepository.removeAccount(existingAccountRecord)) {
            System.out.println("The account has been deleted");
        } else {
            System.out.println("Error deleted");
        }
    }

    private static void updateAccount() {
        System.out.println("Enter the name of an existing account");
        String name = scanner.nextLine();
        Account existingAccountRecord = accountRepository.queryAccount(name);
        if (existingAccountRecord == null) {
            System.out.println("Account not found");
        } else {
            System.out.println("Enter new account name ");
            String newName = scanner.nextLine();
            System.out.println("Enter new account balance");
            double newBalance = scanner.nextDouble();
            Account newAccount = Account.createAccount(newName, newBalance);
            if (accountIdentityService.updateAccount(existingAccountRecord, newAccount)) {
                System.out.println("Account succesfully updated");
            } else {
                System.out.println("Error updating");
            }
        }
    }
}
