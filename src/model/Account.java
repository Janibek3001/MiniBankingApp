package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private final User owner;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account (User owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public void increaseAmount(double amount) {
        balance += amount;
    }

    public void decreaseAmount(double amount) {
        balance -= amount;
    }

    public void setTransactions(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
