package org.example.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("Alex", 2000);
        account.deposit(500);

        assertEquals(2500, account.getBalance());
    }

    @Test
    void testWithdrawn() {
        BankAccount account = new BankAccount("Maria", 1000);
        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("Yelene", 1500);
        account.withdraw(1600);

        assertEquals(1500, account.getBalance());
    }


    @Test
    void testTransfer() {
        BankAccount sender = new BankAccount("Alex", 3000);
        BankAccount receiver = new BankAccount("Maria", 1000);

        sender.transfer(receiver, 1000);

        assertEquals(2000, sender.getBalance());
        assertEquals(2000, receiver.getBalance());
    }
}
