package com.filehandling;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingMain
{
    public static void main(String[] args)
    {
        try(DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("student.dat"))))
        {
            for(int i = 303001, j = 1; i <= 303060; i++, j++)
            {
                ds.writeInt(i);
                ds.writeUTF("\tStudent"+ j +"\n");
                System.out.println(i+"\tStudent"+ j);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
