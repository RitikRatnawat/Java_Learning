package com.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Challenge
{
    public static void main(String[] args) throws Exception
    {
        Runnable runnable = () ->
        {
            // Challenge 1
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts)
                System.out.println(part);
            };

        Thread t1 = new Thread(runnable);
        t1.start();
        t1.join();

        System.out.println("-------------------------------------");

        // Challenge 2
        Function<String, String> lambdaFunction = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++)
            {
                if (i % 2 == 1)
                    returnVal.append(source.charAt(i));
            }

            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("Hello World!"));

        System.out.println("-------------------------------------");

        // Challenge 3
        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println("-------------------------------------");

        // Challenge 4
        System.out.println(everySecondChar(lambdaFunction, "1234567890"));

        System.out.println("-------------------------------------");

        // Challenge 5
        Supplier<String> iLoveJava = () -> "I Love Java";

        // Challenge 6
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("-------------------------------------");

        // Challenge 8
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUppercase = new ArrayList<>();
        topNames2015.forEach(s -> {
            firstUppercase.add(s.substring(0, 1).toUpperCase() + s.substring(1));
        });

        firstUppercase.sort((s1, s2) -> s1.compareTo(s2));
        firstUppercase.forEach(s -> System.out.println(s));

        System.out.println("-------------------------------------");

        // Challenge 7
        firstUppercase.sort(String::compareTo);
        firstUppercase.forEach(System.out::println);

        System.out.println("-------------------------------------");

        // Challenge 8
        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        // Challenge 9
        long cnt = topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(cnt);

        System.out.println("-------------------------------------");

        // Challenge 10
        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    private static String everySecondChar(Function<String, String> func, String str)
    {
        return func.apply(str);
    }
}
