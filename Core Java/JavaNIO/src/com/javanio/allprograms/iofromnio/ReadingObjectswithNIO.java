package com.javanio.allprograms.iofromnio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingObjectswithNIO
{
    public static void main(String[] args)
    {
        Path path = FileSystems.getDefault().getPath("student.dat");

        try(ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path))))
        {
            for(int i = 1; i <= 60; i++)
            {
                Student st = (Student) os.readObject();
                System.out.println(st.getID()+" -> "+st.getName());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException occurred");
            e.printStackTrace();
        }
    }
}
