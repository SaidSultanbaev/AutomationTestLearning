package org.example;

import org.example.Bank.Model.BankAccount;
import org.example.Bank.Repository.BankRepository;
import org.example.Service.BankService;

public class Main {
    public static void main(String[] args) {
        BankRepository bankRepository = new BankRepository();
        BankService bankService = new BankService(bankRepository);

        BankAccount alice = bankService.createAccount("1", "Alice", 5000);
        BankAccount bob = bankService.createAccount("2", "Bob", 3000);

        System.out.println("=== Initial Balance ===");
        printAccount(alice);
        printAccount(bob);

        bankService.deposit("1", 2000);
        System.out.println("\nAfter depositing 2000 into Alice's account:");
        printAccount(alice);

        bankService.withdraw("2", 1000);
        System.out.println("\nAfter withdrawing 1000 from Bob's account:");
        printAccount(bob);

        bankService.transfer("1", "2", 1500);
        System.out.println("\nAfter transferring 1500 from Alice to Bob:");
        printAccount(alice);
        printAccount(bob);
    }

    private static void printAccount(BankAccount account) {
        System.out.println(account.getOwner() + " | Balance: " + account.getBalance());
    }
}
