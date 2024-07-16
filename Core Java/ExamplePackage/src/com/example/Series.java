package com.example;

public class Series
{
    public static int nsum(int n)
    {
        int sum = 0;

        for(int i = 1; i <= n; i++)
        {
            sum += i;
        }

        return sum;
    }

    public static int factorial(int n)
    {
        int fact = 1;

        for(int i = 1; i <= n; i++)
        {
            fact *= i;
        }

        return fact;
    }

    public static int fibonacci(int n)
    {
        int a = 0, b = 1;

        for(int i = 0; i < n - 2; i++)
        {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
