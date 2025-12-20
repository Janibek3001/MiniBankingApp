package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private final User owner;
    private final List<Transaction> transactions;

    Account (User owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.transactions = new ArrayList<>();
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

    public void setTransactions(double amount, TransactionType type) {
        transactions.add(new Transaction(amount, type));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
