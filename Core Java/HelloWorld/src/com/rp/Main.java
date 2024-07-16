package com.rp;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Map<String, Integer> m = new LinkedHashMap<>();

        m.put("one", 1);
        m.put("two", 2);
        m.put("four", 4);
        m.put("three", 3);


        for(Map.Entry<String, Integer> pair : m.entrySet())
        {
            System.out.println(pair.getKey()+ " : "+pair.getValue());
        }
    }
}
