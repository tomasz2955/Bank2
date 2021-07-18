package com.company;

import java.util.Random;

public class Account {
    Random random = new Random();
    private final String accountName;
    private final int accountNumber;
    private double accountBalance;

    public Account(String accountName, double accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountNumber = random.nextInt(88000000)+10000000;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double depositValue) {
        if (depositValue >= 0) {
            this.accountBalance += depositValue;
        }
    }

    public void withdraw(double withdrawValue) {
        if(this.accountBalance>=withdrawValue && withdrawValue > 0) {
            this.accountBalance -= withdrawValue;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }
}