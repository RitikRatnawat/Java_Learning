package com.filehandling;

import java.io.*;

public class ReadingMain
{
    public static void main(String[] args)
    {
        try(DataInputStream di = new DataInputStream(new BufferedInputStream(new FileInputStream("student.dat"))))
        {
            boolean eof = false;
            try
            {
                while (!eof)
                {
                    int rn = di.readInt();
                    String name = di.readUTF();

                    System.out.print(rn + " " + name);
                }
            }
            catch(EOFException e)
            {
                eof = true;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
