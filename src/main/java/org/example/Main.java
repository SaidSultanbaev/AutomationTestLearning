package org.example;

import org.example.Entity.BankAccount;
import org.example.Entity.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Gradle!");

        Person alex = new Person("Alex", 30, "Engineer");
        alex.introduce();
        alex.celebrateBirthday();

        BankAccount mariaAccount = new BankAccount("Maria", 2000);
        BankAccount alexAccount = new BankAccount("Alex", 3000);

        alexAccount.deposit(1000);
        alexAccount.withdraw(500);
        alexAccount.transfer(mariaAccount, 300);

        alexAccount.printTransactionHistory();
    }


}