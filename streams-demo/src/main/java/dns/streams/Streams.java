package dns.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Streams {

    public static List<String> mapToUppercase(String... names) {
        return Arrays.stream(names).map(String::toUpperCase).toList();
    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Arrays.stream(names)
                .<Integer>mapMulti((name, consumer) -> {
                    int length = name.length();
                    if (length > 5) {
                        consumer.accept(length);
                    }
                })
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<String> flatList(List<List<String>> collection) {
        return collection.stream()
                .flatMap(List::stream)
                .toList();
    }

    public static Person getOldestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(Person::age))
                .orElseThrow();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Set<String> getKidNameShouldReturnNamesOfAllKidsUnder18(List<Person> people) {
        return people.stream()
                .filter(person -> person.age() < 18)
                .map(Person::name)
                .collect(Collectors.toSet());
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream()
                .collect(partitioningBy(person -> person.age() >= 18));
    }


    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream()
                .collect(groupingBy(Person::nationality));
    }

    public static String joinNamesSeparatedByString(List<Person> people) {
        return people.stream()
                .map(Person::name)
                .collect(joining(",", "Names: ", "."));
    }

    public static String getEvenOrOdd(List<Integer> list) {
        return list.stream()
                .map(number -> number % 2 == 0 ? "e" + number : "o" + number)
                .collect(joining(","));
    }

}
