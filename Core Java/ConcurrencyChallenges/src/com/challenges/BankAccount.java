package com.challenges;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(double initialBalance, String accountNumber)
    {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public BankAccount(double balance, String accountNumber, ReentrantLock lock)
    {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = lock;
    }

    //    public synchronized void deposit(double amount)
//    {
//        this.balance += amount;
//    }
//
//    public synchronized void withdraw(double amount)
//    {
//        this.balance -= amount;
//    }

//    public void deposit(double amount)
//    {
//        synchronized (this)
//        {
//            this.balance += amount;
//        }
//    }
//
//    public void withdraw(double amount)
//    {
//        synchronized (this)
//        {
//            this.balance -= amount;
//        }
//    }

    public void deposit(double amount)
    {
        boolean status = false;
        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try
                {
                    this.balance += amount;
                    status = true;
                }
                finally
                {
                    lock.unlock();
                }
            }
            else
            {
                System.out.println("Couldn't acquire the lock");
            }
        }
        catch (InterruptedException e)
        {

        }

        System.out.println("Transcation Status : "+status);
    }

    public void withdraw(double amount)
    {
        boolean status = false;
        try
        {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS))
            {
                try
                {
                    this.balance -= amount;
                    status = true;
                }
                finally
                {
                    lock.unlock();
                }
            }
            else
            {
                System.out.println("Couldn't acquire the Lock");
            }
        }
        catch (InterruptedException e)
        {

        }

        System.out.println("Transaction Status : "+status);
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void printAccountNumber()
    {
        System.out.println("Account Number : "+accountNumber);
    }
}
