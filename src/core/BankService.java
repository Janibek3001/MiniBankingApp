package core;

import model.*;
import exception.NotEnoughFoundException;

public class BankService {
    private final Bank bank = new Bank();

    public User register(String name, int phoneNumber, String password) {
        User user = new User(name, phoneNumber, password);
        bank.addUser(user);
        return user;
    }

    public boolean hasNumber(int phoneNumber) {
        return bank.findUser(phoneNumber) != null;
    }

    public boolean hasAccount(User user) {
        return bank.findAccount(user) != null; // if User has account, it will return true
    }

    public void createAccount(User user, double balance) {
        bank.addAccount(new Account(user, balance));
    }

    public User login(int phoneNumber, String password) {
        User user = bank.findUser(phoneNumber);
        return (user != null && user.checkPassword(password)) ? user : null;
    }

    public void showBalance(User user) {
        Account userBalance = bank.findAccount(user);
        System.out.println("Balance: " + userBalance.getBalance());
    }

    public void deposit(User user, double amount) {
        Account acc = bank.findAccount(user);
        acc.increaseAmount(amount);
        acc.setTransactions(new Transaction(amount, TransactionType.DEPOSIT));
    }

    public void withdraw(User user, double amount) throws NotEnoughFoundException{
        Account acc = bank.findAccount(user);
        if (acc.getBalance() < amount)
            throw new NotEnoughFoundException("Not enough Money");
        acc.decreaseAmount(amount);
        acc.setTransactions(new Transaction(amount, TransactionType.WITHDRAW));
    }
}
