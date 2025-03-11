package org.example.Entity;

import org.example.Bank.Model.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("1", "Alex", 2000);
        account.deposit(500);

        assertEquals(2500, account.getBalance());
    }

    @Test
    void testWithdrawn() {
        BankAccount account = new BankAccount("123", "Maria", 1000);
        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("456", "Yelene", 1500);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1600);
        });

        assertEquals("Not enough balance!", exception.getMessage());
    }

    @Test
    void testTransfer() {
        BankAccount sender = new BankAccount("789", "Alex", 3000);
        BankAccount receiver = new BankAccount("987", "Maria", 1000);

        sender.transfer(receiver, 1000);

        assertEquals(2000, sender.getBalance());
        assertEquals(2000, receiver.getBalance());
    }

    @Test
    @DisplayName("Deposit Positive Amount")
    void depositPositiveAmount() {
        BankAccount account = new BankAccount("111", "Alice", 1000);
        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    @DisplayName("Deposit Negative Amount")
    void depositNegativeAmount() {
        BankAccount account = new BankAccount("222", "Alice", 1000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200);
        });

        assertEquals("Deposit amount must be positive!", exception.getMessage());
    }

    @Test
    @DisplayName("Successful Transfer")
    void successfulTransfer() {
        BankAccount alice = new BankAccount("333", "Alice", 2000);
        BankAccount alex = new BankAccount("444", "Alex", 3000);

        alice.transfer(alex, 800);

        assertEquals(1200, alice.getBalance());
        assertEquals(3800, alex.getBalance());
    }

    @Test
    @DisplayName("Transfer More Than Balance")
    void transferMoreThanBalance() {
        BankAccount alice = new BankAccount("555", "Alice", 5000);
        BankAccount bob = new BankAccount("666", "Bob", 1000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            alice.transfer(bob, 6000);
        });

        assertEquals("Not enough balance for transfer!", exception.getMessage());
    }
}
