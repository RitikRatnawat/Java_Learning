package org.concurrency;


import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 7");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 4");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 1");

        t1.setPriority(10);
        t2.setPriority(7);
        t3.setPriority(4);
        t4.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private static class Worker implements Runnable
    {
        private int runcount = 1;
        private String color;

        public Worker(String color)
        {
            this.color = color;
        }

        @Override
        public void run()
        {
            for(int i = 1; i <= 100; i++)
            {
//                synchronized (lock)
//                {
//                    System.out.format(color+"%s : runcount = %d\n", Thread.currentThread().getName(), runcount++);
//                }
                lock.lock();

                try
                {
                    System.out.format(color+"%s : runcount = %d\n", Thread.currentThread().getName(), runcount++);
                }
                finally
                {
                    lock.unlock();
                }
            }
        }
    }
}
