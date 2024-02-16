package dns.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

}
