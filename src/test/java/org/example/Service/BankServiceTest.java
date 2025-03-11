package org.example.Service;

import org.example.Bank.Model.BankAccount;
import org.example.Bank.Repository.BankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
    @Mock
    private BankRepository bankRepository;

    private BankService bankService;  // No @InjectMocks

    @BeforeEach
    void setUp() {
        bankService = new BankService(bankRepository);
    }

    @Test
    @DisplayName("Should successfully create a new bank account")
    void shouldCreateAccountSuccessfully() {
        BankAccount newAccount = new BankAccount("1", "Alice", 1000);
        doNothing().when(bankRepository).save(any(BankAccount.class));

        BankAccount result = bankService.createAccount("1", "Alice", 1000);

        assertNotNull(result);
        assertEquals("Alice", result.getOwner());
        assertEquals(1000, result.getBalance());

        verify(bankRepository).save(any(BankAccount.class));
    }

    @Test
    @DisplayName("Should deposit money successfully")
    void shouldDepositMoneySuccessfully() {
        BankAccount alice = new BankAccount("1", "Alice", 1000);
        when(bankRepository.findById("1")).thenReturn(Optional.of(alice));

        bankService.deposit("1", 500);

        assertEquals(1500, alice.getBalance());
        verify(bankRepository).update(alice);
    }

    @Test
    @DisplayName("Should withdraw money successfully")
    void shouldWithdrawMoneySuccessfully() {
        BankAccount alice = new BankAccount("1", "Alice", 1000);
        when(bankRepository.findById("1")).thenReturn(Optional.of(alice));

        bankService.withdraw("1", 500);

        assertEquals(500, alice.getBalance());
        verify(bankRepository).update(alice);
    }

    @Test
    @DisplayName("Should transfer money successfully between accounts")
    void shouldTransferMoneySuccessfully() {
        BankAccount alice = new BankAccount("1", "Alice", 1000);
        BankAccount bob = new BankAccount("2", "Bob", 500);

        when(bankRepository.findById("1")).thenReturn(Optional.of(alice));
        when(bankRepository.findById("2")).thenReturn(Optional.of(bob));

        bankService.transfer("1", "2", 200);

        assertEquals(800, alice.getBalance());
        assertEquals(700, bob.getBalance());

        verify(bankRepository, times(2)).update(any(BankAccount.class));
    }

    @Test
    @DisplayName("Should throw an exception when insufficient funds for transfer")
    void shouldThrowExceptionWhenInsufficientFunds() {
        BankAccount alice = new BankAccount("1", "Alice", 100);

        when(bankRepository.findById("1")).thenReturn(Optional.of(alice));
        when(bankRepository.findById("2")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            bankService.transfer("1", "2", 200);
        });

        verify(bankRepository, never()).update(any(BankAccount.class));
    }
}
