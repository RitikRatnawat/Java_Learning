package com.lambdas;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams
{
    public static void main(String[] args)
    {
        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36", "N21",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

//        List<String> gNumbers = new ArrayList<>();
//
//        bingoNumbers.forEach( num -> {
//            if(num.toUpperCase().startsWith("G"))
//                gNumbers.add(num);
////                System.out.println(num);
//        });
//
//        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//        gNumbers.forEach(num -> System.out.println(num));

        bingoNumbers.stream().map(String::toUpperCase).filter(s->s.startsWith("G"))
                .sorted().forEach(System.out::println);

        Stream<String> ioStream = Stream.of("I12", "I26", "I10", "O6");
        Stream<String> niStream = Stream.of("I12", "I26", "N40", "N36");
        Stream<String> concatStream = Stream.concat(ioStream, niStream);
        System.out.println("------------------------------------");
        System.out.println(concatStream.distinct().peek(System.out::println).count());

        System.out.println("------------------------------------");
//        List<String> sortedGnumbers = bingoNumbers.stream().map(String::toUpperCase)
//                .filter(s->s.startsWith("G")).sorted().collect(Collectors.toList());

        List<String> sortedGnumbers = bingoNumbers.stream().map(String::toUpperCase)
                .filter(s->s.startsWith("G")).sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : sortedGnumbers)
            System.out.println(s);
    }
}
