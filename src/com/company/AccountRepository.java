package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {

    List<Account> bankAccounts; //private

    public AccountRepository(String myNumber) { //nie uzyte
        this.bankAccounts = new ArrayList<>();

    }

    public boolean addNewAccount(Account account) {
        if (findAccount(account.getName()) >= 0) {
            System.out.println("Account is already exists");
            return false;
        } else {
            bankAccounts.add(account);
            return true;
        }
    }

    //sugeruje ze dostaniesz account. moze accountExists()
    public int findAccount(String accountName) {
        for (int i = 0; i < this.bankAccounts.size(); i++) {
            Account account = this.bankAccounts.get(i);
            if (account.getName().equals(accountName)) {
                return i;
            }
        }
        //streamy
//        bankAccounts.stream().anyMatch(account -> account.getName().equals(accountName));

        return -1; //booleany

    }
    public Account queryAccount(String name) {
        int position = findAccount(name); //2 razy iterujesz przez wszystkie konta
        if(position >=0) {
            return this.bankAccounts.get(position);
        }

//        Account account1 = bankAccounts.stream()
//                .filter(account -> account.getName().equals(name))
//                .findFirst()
//                .orElse(null);


        return null;
    }



    //po co caly account, wystarczy identyfikator
    public boolean removeAccount(Account account) {
        int foundPosition = findAccount(account.getName());
        if(foundPosition < 0) {
            System.out.println(account.getName() + " was not found");
            return false;
        } else {
            this.bankAccounts.remove(foundPosition);
            System.out.println(account.getName() + " was deleted");
            return true;

        }
    }
    public void printContacts() {
        System.out.println("Account list");
        //foreach for(Account account: bankAccounts)
        //jeszcze lepiej stream bankAccounts.forEach(account -> System.out.println(account));
        //jeszcze jeszcze lepiej stream z method reference  bankAccounts.forEach(System.out::println);
        for(int i=0; i<this.bankAccounts.size(); i++) {
            System.out.println((i+1) + ". Name: " +
                    this.bankAccounts.get(i).getName() + ", Account number: " + // pomyslmy ze bankAccounts ma 37 milionów kont
                    this.bankAccounts.get(i).getAccountNumber() + ", Balance: " + this.bankAccounts.get(i).getBalance());
        }
    }

}
