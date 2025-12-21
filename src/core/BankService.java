package core;

import model.*;
import exception.NotEnoughFoundException;

public class BankService {
    private final Bank bank = new Bank();

    public void register(String name, int phoneNumber, String password) {
        bank.addUser(new User(name, phoneNumber, password));
    }

    public boolean hasAccount(User user) {
        return bank.findAccount(user) != null; // if User has account, it will return true
    }

    public User login(int phoneNumber, String password) {
        User user = bank.findUser(phoneNumber);
        return (user != null && user.checkPassword(password)) ? user : null;
    }

    public void deposit(User user, double amount) {
        Account acc = bank.findAccount(user);
        acc.increaseAmount(amount);
        acc.setTransactions(new Transaction(amount, TransactionType.DEPOSIT));
    }

    public void withdraw(User user, double amount) {
        Account acc = bank.findAccount(user);
        if (acc.getBalance() < amount)
            new ClassNotFoundException();
        acc.decreaseAmount(amount);
        acc.setTransactions(new Transaction(amount, TransactionType.WITHDRAW));
    }
}
