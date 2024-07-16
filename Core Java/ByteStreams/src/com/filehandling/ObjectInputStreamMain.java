package com.filehandling;

import java.io.*;

public class ObjectInputStreamMain
{
    public static void main(String[] args)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("student.dat"))))
        {
            boolean eof = false;
            try
            {
                while (!eof)
                {
                    Student stu = (Student) ois.readObject();
                    System.out.println(stu.getRollNo() + " " + stu.getName());
                }
            }
            catch(InvalidClassException e)
            {
                System.out.println("We got InvalidClassException");
            }
            catch(EOFException e)
            {
                eof = true;
            }
            catch(ClassNotFoundException e)
            {
                System.out.println("ClassNotFoundException "+e.getMessage());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
