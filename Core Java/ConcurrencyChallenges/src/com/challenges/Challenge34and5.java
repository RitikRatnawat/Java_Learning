package com.challenges;

import java.util.concurrent.locks.ReentrantLock;

public class Challenge34and5
{
    public static void main(String[] args)
    {
        ReentrantLock lock = new ReentrantLock();
        BankAccount acc = new BankAccount(1000, "12345-678", lock);

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                acc.deposit(300);
                System.out.println(ThreadColor.ANSI_GREEN + "Amount Deposited");
                acc.deposit(50);
                System.out.println(ThreadColor.ANSI_GREEN + "Amount Withdrawn");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run()
            {
                acc.deposit(203.75);
                System.out.println(ThreadColor.ANSI_CYAN + "Amount Deposited");
                acc.withdraw(100);
                System.out.println(ThreadColor.ANSI_CYAN + "Amount Withdrawn");
            }
        }).start();
    }
}
