package com.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread
{
    private Socket socket;

    public Echoer(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("Client Connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true)
            {
                String echoString = input.readLine();

                if (echoString.equals("exit"))
                    break;

                try
                {
                    Thread.sleep(15000);
                }
                catch(InterruptedException e)
                {
                    System.out.println("Thread interrupted");
                }

                output.println("Echo from Server  : " + echoString);
            }
        }
        catch(IOException e)
        {
            System.out.println("OOPS : "+e.getMessage());
        }
    }
}
