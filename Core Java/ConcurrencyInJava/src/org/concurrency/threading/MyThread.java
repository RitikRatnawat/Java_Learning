package org.concurrency.threading;

import static org.concurrency.threading.ThreadColor.ANSI_BLUE;

public class MyThread extends Thread
{
    @Override
    public void run()
    {
        System.out.println(ANSI_BLUE+"Saying Hello from "+currentThread().getName());

        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            System.out.println(ANSI_BLUE+"My Thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE+"Three seconds are passed and I'm awake");
    }
}
