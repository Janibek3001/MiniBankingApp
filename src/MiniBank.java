import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class NotEnoughFoundException extends Exception{
    NotEnoughFoundException(String message) {
        super(message);
    }
}

class Transaction {
    private String type;
    private double amount;
    private LocalDateTime dateTime;
    private String description;

    public Transaction (String type, double amount, String description) {
        this.type = type; //type of the Transaction
        this.amount = amount; // amount
        this.description = description; // some kinda description
        this.dateTime = LocalDateTime.now();
    }
}

public class MiniBank {
}
