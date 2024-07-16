package com.exception;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        int x = 80;
//        int y = 0;
//
//        System.out.println(divide3(x, y));
//        System.out.println(divide(x, y));
//        System.out.println(divide2(x, y));

        int x = getIntLBYL();
        System.out.println("The value of the x : "+x);
    }

    private static int getInt()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int getIntLBYL()
    {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        String input = sc.next();

        for(int i = 0; i < input.length(); i++)
        {
            if(!Character.isDigit(input.charAt(i)))
            {
                isValid = false;
                break;
            }
        }

        if(isValid)
            return Integer.parseInt(input);

        return 0;
    }

    private static int divide(int x, int y)
    {
        if(y != 0)
        {
            return x/y;
        }
        else
        {
            return 0;
        }
    }

    private static int divide2(int x, int y)
    {
        try
        {
            return x/y;
        }
        catch(ArithmeticException e)
        {
            return 0;
        }
    }

    private static int divide3(int x, int y)
    {
        return x/y;
    }
}
