package org.example.Bank.Model;

import org.example.Entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String id;
    private final String owner;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(String id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        this.balance += amount;
        transactions.add(new Transaction("Deposited", amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough balance!");
        }
        this.balance -= amount;
        transactions.add(new Transaction("Withdrawn", amount));
    }

    public void transfer(BankAccount to, double amount) {
        if (to == null) {
            throw new IllegalArgumentException("Receiver account does not exist!");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive!");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Not enough balance for transfer!");
        }

        this.withdraw(amount);
        to.deposit(amount);

        transactions.add(new Transaction("Transferred to " + to.owner, amount));
        to.transactions.add(new Transaction("Received from " + this.owner, amount));
    }

    public void printTransactionHistory() {
        System.out.println("==========================");
        System.out.println("Transaction history for " + owner + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getFormattedTransaction());
        }
    }
}
