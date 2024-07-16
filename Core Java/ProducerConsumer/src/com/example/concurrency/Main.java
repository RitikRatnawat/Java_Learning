package com.example.concurrency;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Message msg = new Message();

        (new Thread(new Writer(msg))).start();
        (new Thread(new Reader(msg))).start();
    }
}

class Message
{
    private String message;
    private boolean empty = true;

    public synchronized String read()
    {
        while(empty)
        {
            try
            {
               wait();
            }
            catch(InterruptedException e)
            {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message)
    {
        while(!empty)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable
{
    private Message msgobj;

    public Writer(Message obj)
    {
        this.msgobj = obj;
    }

    @Override
    public void run()
    {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for(int i = 0; i < messages.length; i++)
        {
            msgobj.write(messages[i]);

            try
            {
                Thread.sleep(random.nextInt(2000));
            }
            catch(InterruptedException e)
            {
            }
        }

        msgobj.write("Finished");
    }
}

class Reader implements Runnable
{
    private Message msgObj;

    public Reader(Message obj)
    {
        this.msgObj = obj;
    }

    @Override
    public void run()
    {
        Random random = new Random();

        for(String msg = msgObj.read(); !msg.equals("Finished"); msg = msgObj.read())
        {
            System.out.println(msg);

            try
            {
                Thread.sleep(random.nextInt(2000));
            }
            catch(InterruptedException e)
            {
            }
        }
    }
}
