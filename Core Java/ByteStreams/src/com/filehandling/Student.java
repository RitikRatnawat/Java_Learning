package com.filehandling;

import java.io.Serializable;

public class Student implements Serializable
{
    private int rollNo;
    private String name;

    private long serialVersionUID = 1L;

    public Student(int rollNo, String name)
    {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName()
    {
        return name;
    }

    public int getRollNo()
    {
        return rollNo;
    }


}
