package com.testing;

public class BankAccount
{
    private String firstName;
    private String lastName;
    private double balance;
    private int accountType;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }

    public double deposit(double amount, boolean branch)
    {
        this.balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch)
    {
        if(amount > 500.00 && !branch)
            throw new IllegalArgumentException();

        this.balance -= amount;
        return balance;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public boolean isChecking()
    {
        return this.accountType == CHECKING;
    }
}
