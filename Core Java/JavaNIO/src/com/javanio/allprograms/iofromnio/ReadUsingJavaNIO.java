package com.javanio.allprograms.iofromnio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadUsingJavaNIO
{
    public static void main(String[] args)
    {
        Path sdLoc = FileSystems.getDefault().getPath("student.txt");

        try(Scanner sc = new Scanner(Files.newBufferedReader(sdLoc)))
        {
            for(int i = 1; i <= 60; i++)
            {
                sc.useDelimiter(",");

                while(sc.hasNextLine())
                {
                    int sno = sc.nextInt();
                    sc.skip(sc.delimiter());
                    String name = sc.nextLine();

                    System.out.println(sno+". "+name);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
