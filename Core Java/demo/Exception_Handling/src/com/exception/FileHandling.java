package com.exception;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling
{
    public static void main(String[] args) throws IOException
    {
        try(FileWriter file1 = new FileWriter("test.txt");
            FileWriter file2 = new FileWriter("test2.txt");)
        {
            for(int i = 1; i <= 10; i++)
            {
                file1.write("2 x 1 = " + (2 * i) + "\n");
                file2.write("3 x 1 = " + (3 * i) + "\n");
            }
        }

        Scanner sc = null;

        try
        {
            sc = new Scanner(new FileReader("test.txt"));

            while(sc.hasNextLine())
            {
                String str = sc.nextLine();
                System.out.println(str);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(sc != null)
                sc.close();
        }
//        FileWriter file = null;
//        try
//        {
//            file = new FileWriter("test.txt");
//            for(int i = 1; i <= 10; i++)
//            {
//                file.write("2 x 1 = " + (2 * i) + "\n");
//                throw new IOException("checking throws keyword");
//            }
//        }
//        finally
//        {
//            System.out.println("In Finally Block");
//            if(file != null)
//            {
//                System.out.println("Attempting to Close File");
//                file.close();
//            }
//        }
    }
}
