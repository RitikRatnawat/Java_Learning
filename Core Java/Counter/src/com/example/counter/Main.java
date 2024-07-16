package com.example.counter;

import org.concurrency.threading.ThreadColor;

public class Main
{
    public static void main(String[] args)
    {
        CountDown cntdwn = new CountDown();
//        CountDown cntdwn2 = new CountDown();

        CounterThread t1 = new CounterThread(cntdwn);
        t1.setName("Thread 1");

        CounterThread t2 = new CounterThread(cntdwn);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class CountDown
{
    private int i;
    public void doCountDown()
    {
        String color;

        switch(Thread.currentThread().getName())
        {
            case "Thread 1":
                color = ThreadColor.ANSI_GREEN;
                break;

            case "Thread 2":
                color = ThreadColor.ANSI_BLUE;
                break;

            default:
                color = ThreadColor.ANSI_RED;
        }

        synchronized(this)
        {
            for (i = 10; i >= 1; i--)
                System.out.println(color + Thread.currentThread().getName() + " : i = " + i);
        }
    }
}

class CounterThread extends Thread
{
    private CountDown cd;

    public CounterThread(CountDown cdn)
    {
        this.cd = cdn;
    }

    @Override
    public void run()
    {
        cd.doCountDown();
    }
}
