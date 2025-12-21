package model;

import java.time.LocalDateTime;

public class Transaction {
    private final TransactionType type;
    private final LocalDateTime dateTime;
    private final double amount;

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return amount + "|" + type + "|" + dateTime;
    }
}
