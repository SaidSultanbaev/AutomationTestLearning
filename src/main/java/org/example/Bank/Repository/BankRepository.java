package org.example.Bank.Repository;

import org.example.Bank.Model.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankRepository {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void save(BankAccount account) {
        accounts.put(account.getId(), account); // Используем id вместо имени
    }

    public Optional<BankAccount> findById(String id) {
        return Optional.ofNullable(accounts.get(id)); // Поиск по id
    }

    public void update(BankAccount account) {
        accounts.put(account.getId(), account); // Обновление по id
    }
}
