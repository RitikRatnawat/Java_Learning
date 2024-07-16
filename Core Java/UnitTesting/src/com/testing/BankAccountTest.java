package com.testing;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass()
    {
        System.out.println("These executes before any test cases. Count = "+count++);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup()
    {
        account = new BankAccount("Steve", "Rogers", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        Exception exc = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600.00, false);
        });
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking(), "The Account is NOT Checking");
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown()
    {
        System.out.println("Count = "+count++);
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass()
    {
        System.out.println("These executes after any test cases. Count = "+count++);
    }
}

