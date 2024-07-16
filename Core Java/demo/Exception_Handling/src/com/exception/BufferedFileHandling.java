package com.exception;

import java.io.*;

public class BufferedFileHandling
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt")))
        {
            String str;
            while((str = br.readLine()) != null)
                System.out.println(str);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("combined.txt"));
            BufferedReader br1 = new BufferedReader(new FileReader("test.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("test2.txt")))
        {
            String in1, in2;
            while((in1 = br1.readLine()) != null && (in2 = br2.readLine()) != null)
            {
                bw.write(in1 + "\t" + in2 + "\n");
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
