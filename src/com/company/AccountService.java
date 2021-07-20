package com.company;

public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void deposit(String accountName, double depositValue) {
        Account account = repository.findAccount(accountName);
        //jak findAccount bedzie zwracać optionala to zamiast sprawdzać czy coś nie jest nullem mozesz
        //uzyć takiej metody jak isPresent(). Sprawdzanie nulla jest średnio odbierane
        if(repository.findAccount(accountName) != null) {
            account.deposit(depositValue);
        }
    }

    public void withdraw(String accountName, double withdrawValue) {
        Account account = repository.findAccount(accountName);
        if(repository.findAccount(accountName) != null) {
            account.withdraw(withdrawValue);
        }
        // a co w sytuacji gdy nie znajdzie konta? trzeba to obsłużyć żeby tez przetestować to w tescie
    }

    public void transfer(String withdrawAccountName, String depositAccountName, double transferValue) {
        Account withdrawAccount = repository.findAccount(withdrawAccountName);
        Account depositAccount = repository.findAccount(depositAccountName);
        if(repository.findAccount(withdrawAccountName) != null && repository.findAccount(depositAccountName) != null) {
            withdrawAccount.withdraw(transferValue);
            depositAccount.deposit(transferValue);
        }
        // a co jak konta jakiegos nie ma? trzeba je osobno obsłużyć zeby w tescie móc sprawdzić którego konta brakowało
    }



}
