package com.javanio.allprograms.iofromnio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingObjectswithNIO
{
    public static void main(String[] args)
    {
        Path stuPath = FileSystems.getDefault().getPath("student.dat");

        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(stuPath))))
        {
            for(int i = 1; i <= 60; i++)
            {
                System.out.println(i+". Student"+i);
                os.writeObject(new Student(i, "Student"+i));
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
