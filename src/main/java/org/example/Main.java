package org.example;


import org.example.Bank.Model.BankAccount;
import org.example.Entity.Person;


public class Main {
    public static void main(String[] args) {
        Person alex = new Person("Alex", 30, "Engineer");
        alex.introduce();
        alex.celebrateBirthday();

        BankAccount mariaAccount = new BankAccount("1", "Maria", 2000);
        BankAccount alexAccount = new BankAccount("2", "Alex", 3000);

        alexAccount.deposit(1000);
        alexAccount.withdraw(500);
        alexAccount.transfer(mariaAccount, 300);
    }


}