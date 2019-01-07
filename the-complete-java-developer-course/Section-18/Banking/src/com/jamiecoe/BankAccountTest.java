package com.jamiecoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void deposit() {
        BankAccount bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(300.00, balance, 0);
    }

    @Test
    public void withdraw() {
        BankAccount bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);

    }

    @Test
    public void getBalance_deposit() {
        BankAccount bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(300.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        BankAccount bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);
        double balance = bankAccount.withdraw(50.00, true);
        assertEquals(50.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        BankAccount bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);
        assertTrue(bankAccount.isChecking());
    }
}
