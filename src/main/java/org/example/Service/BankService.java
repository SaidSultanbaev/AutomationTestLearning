package org.example.Service;

import org.example.Bank.Model.BankAccount;
import org.example.Bank.Repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankService {
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public BankAccount createAccount(String id, String owner, double initialBalance) {
        logger.info("Creating account for owner: {} with initial balance: {}", owner, initialBalance);
        BankAccount account = new BankAccount(id, owner, initialBalance);
        bankRepository.save(account);
        logger.info("Account created successfully: {}", account);
        return account;
    }

    public void deposit(String id, double amount) {
        logger.info("Depositing {} to account {}", amount, id);
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Deposit failed: Account {} not found", id);
                    return new IllegalArgumentException("Account not found");
                });
        account.deposit(amount);
        bankRepository.update(account);
        logger.info("Deposit successful. New balance: {}", account.getBalance());
    }

    public void withdraw(String id, double amount) {
        logger.info("Withdrawing {} from account {}", amount, id);
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Withdrawal failed: Account {} not found", id);
                    return new IllegalArgumentException("Account not found");
                });
        try {
            account.withdraw(amount);
            bankRepository.update(account);
            logger.info("Withdrawal successful. New balance: {}", account.getBalance());
        } catch (IllegalArgumentException e) {
            logger.error("Withdrawal failed: {}", e.getMessage());
            throw e;
        }
    }

    public void transfer(String fromId, String toId, double amount) {
        logger.info("Transferring {} from account {} to account {}", amount, fromId, toId);
        BankAccount from = bankRepository.findById(fromId)
                .orElseThrow(() -> {
                    logger.error("Transfer failed: Sender account {} not found", fromId);
                    return new IllegalArgumentException("Sender account not found");
                });

        BankAccount to = bankRepository.findById(toId)
                .orElseThrow(() -> {
                    logger.error("Transfer failed: Receiver account {} not found", toId);
                    return new IllegalArgumentException("Receiver account not found");
                });

        try {
            from.transfer(to, amount);
            bankRepository.update(from);
            bankRepository.update(to);
            logger.info("Transfer successful. New balances -> {}: {}, {}: {}", fromId, from.getBalance(), toId, to.getBalance());
        } catch (IllegalArgumentException e) {
            logger.error("Transfer failed: {}", e.getMessage());
            throw e;
        }
    }

    public void printTransactionHistory(String id) {
        BankAccount account = bankRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Transaction history failed: Account {} not found", id);
                    return new IllegalArgumentException("Account not found");
                });
        logger.info("Printing transaction history for account {}", id);
        account.printTransactionHistory();
    }
}
