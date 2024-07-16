package org.concurrency.threading;

import static org.concurrency.threading.ThreadColor.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(ANSI_GREEN+"Saying Hello from Main Thread");

        Thread t1 = new MyThread();
        t1.setName("** My Thread **");
        t1.start();

        new Thread(){
            @Override
            public void run()
            {
                System.out.println(ANSI_PURPLE+"Saying Hello from Anonymous Thread Class");
            }
        }.start();

        Thread rt1 = new Thread(new MyRunnable()
        {
            @Override
            public void run()
            {
                System.out.println(ANSI_RED+"Saying Hello from anonymous implementation of run()");
                try
                {
                    t1.join(2000);
                    System.out.println(ANSI_RED+"My Thread terminated or timed out, I'm running again");
                }
                catch(InterruptedException e)
                {
                    System.out.println(ANSI_RED+"I am interrupted");
                }
            }
        });

        rt1.start();
//        t1.interrupt();

        System.out.println(ANSI_GREEN+"Hello Again from Main Thread");
    }
}
