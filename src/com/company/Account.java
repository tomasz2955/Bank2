package com.company;

import java.util.Random;

public class Account {
    Random random = new Random();
    private final String name;
    private final int accountNumber;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = random.nextInt(88000000)+10000000;
    }

    public void deposit(double cash) {
        this.balance += cash;
        System.out.println("You have deposited " + cash + " PLN. Your account balance is " + this.balance + "PLN.");
    }

    public void withdraw(double cash) { //ujemne wartosci?
        if(this.balance<cash) {
            System.out.println("Not enough money");
        } else {
            this.balance -= cash;
            System.out.println("You have withdrawn " + cash + " PLN. Your account balance is " + this.balance + "PLN.");
        }
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static Account createAccount(String name, double balance) { // https://stackoverflow.com/questions/8148684/what-data-type-to-use-for-money-in-java
        return new Account(name, balance);
    }


}
