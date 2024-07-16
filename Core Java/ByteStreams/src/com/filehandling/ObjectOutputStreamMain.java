package com.filehandling;

import java.io.*;

public class ObjectOutputStreamMain
{
    public static void main(String[] args)
    {
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("student.dat"))))
        {
            for(int i = 303001, j = 1; i <= 303060; i++, j++)
            {
                Student stu = new Student(i, "Student"+j);
                os.writeObject(stu);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
