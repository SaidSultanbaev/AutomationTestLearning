package org.example.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    private String description;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getFormattedTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter) + " | " + description + ": $" + String.format("%.2f", amount);
    }
}
