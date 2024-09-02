package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main
{
    public static <T> void main(String[] args)
    {
        ArrayList<String> names = new ArrayList<>();
        names.add("Andrey");
        names.add("Artem");
        names.add("Zendaya");
        names.add("Iker");
        names.add("Eric");
        names.add("Robert");
        names.add("BOB");
        names.add("Lea");
        names.add("Carlos");
        names.add("Amigo");



        List<String> oddNamesSort = IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i))
                .toList();
        System.out.println("TASK 1: " + oddNamesSort);


        List<String> sortedZtoANames = names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Task 2: " + sortedZtoANames);


        String[] array = {"1, 2, 0", "4, 5"};

        String sortedNumbers = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("sortedNumbers = " + sortedNumbers);


        Stream<String> first = Stream.of("hello ", "name ", "Andrey ","you");
        Stream<String> second = Stream.of("my ", "is ", "thank ");
        Stream<String> zipped = zip(first, second);
        zipped.forEach(System.out::print);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    {
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();

        int minSize = Math.min(firstList.size(), secondList.size());

        return IntStream.range(0, minSize)
                .mapToObj(i -> Stream.of(firstList.get(i), secondList.get(i)))
                .flatMap(s -> s);
    }
}