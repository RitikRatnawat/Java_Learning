package com.testing;

public class Utilities
{
    public char[] everynthChar(char[] source, int n)
    {
        if(source == null || source.length < n)
            return source;

        int returnArrLen = source.length/n;
        char[] returnArr = new char[returnArrLen];
        int index = 0;

        for(int i = n-1; i < source.length; i+=n)
            returnArr[index++] = source[i];

        return returnArr;
    }

    public String removePairs(String source)
    {
        if(source == null || source.length() < 2)
            return source;

        StringBuilder ans = new StringBuilder();
        char[] str = source.toCharArray();
        int i;

        for(i = 0; i < str.length - 1; i++)
        {
            if(str[i] != str[i+1])
                ans.append(str[i]);
        }

        ans.append(str[str.length-1]);

        return ans.toString();
    }

    public int converter(int a, int b)
    {
        return (a/b) + (a*30) - 2;
    }

    public String nullIfOddLength(String source)
    {
        if(source.length() % 2 == 0)
            return source;

        return null;
    }
}
