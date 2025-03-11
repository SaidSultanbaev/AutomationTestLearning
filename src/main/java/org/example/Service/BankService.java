package org.example.Service;

import org.example.Bank.Model.BankAccount;
import org.example.Bank.Repository.BankRepository;

public class BankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BankAccount createAccount(String id, String owner, double initialBalance) {
        BankAccount account = new BankAccount(id, owner, initialBalance);
        bankRepository.save(account);
        return account;
    }

    public void deposit(String id, double amount) {
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.deposit(amount);
        bankRepository.update(account);
    }

    public void withdraw(String id, double amount) {
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.withdraw(amount);
        bankRepository.update(account);
    }

    public void transfer(String fromId, String toId, double amount) {
        BankAccount from = bankRepository.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));
        BankAccount to = bankRepository.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

        from.transfer(to, amount);
        bankRepository.update(from);
        bankRepository.update(to);
    }

    public void printTransactionHistory(String id) {
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.printTransactionHistory();
    }
}
