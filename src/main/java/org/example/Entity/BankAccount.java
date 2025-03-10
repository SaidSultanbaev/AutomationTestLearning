package org.example.Entity;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String owner;
    private double balance;

    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printAccountDetails() {
        System.out.println("Account owner: " + owner);
        System.out.println("Current balance: $" + String.format("%.2f", balance));
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
            transactions.add(new Transaction("Deposited", amount));
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough balance! Available: " + balance);
        } else if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount);
            transactions.add(new Transaction("Withdrawn", amount));
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    public void displayBalance() {
        System.out.println("Balance for " + owner + ": " + balance);
    }

    public void transfer(BankAccount to, double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            to.balance += amount;
            System.out.println("Transferred " + amount + " from " + this.owner + " to " + to.owner);

            transactions.add(new Transaction("Transfered to " + to.owner, amount));
            to.transactions.add(new Transaction("Received from " + this.owner, amount));
        } else {
            System.out.println("Transfer failed! Not enough balance or incorrect amount.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("==========================" + "\n" + "Transaction history for " + owner + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getFormattedTransaction());
        }
    }
}
