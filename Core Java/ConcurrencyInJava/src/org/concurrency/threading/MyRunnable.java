package org.concurrency.threading;

import static org.concurrency.threading.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        System.out.println(ANSI_RED+"Saying Hello from MyRunnable");
    }
}
