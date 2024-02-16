package dns.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsTest {

    @Test
    void mapToUppercase() {
        List<String> result = Streams.mapToUppercase("aaron", "frank", "william", "gilliam", "cegeka");
        assertEquals(List.of("AARON", "FRANK", "WILLIAM", "GILLIAM", "CEGEKA"), result);
    }

    @Test
    void getTotalNumberOfLettersOfNamesLongerThanFive() {
        int result = Streams.getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam");
        assertEquals(14, result);
    }

    @Test
    void flatList() {
        List<List<String>> collection = List.of(List.of("Viktor", "Farcic"), List.of("John", "Doe", "Third"));
        List<String> expected = List.of("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = Streams.flatList(collection);
        assertEquals(expected, result);
    }

    @Test
    void getOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);

        List<Person> people = List.of(sara, eva, viktor);
        Person result = Streams.getOldestPerson(people);

        assertEquals(eva, result);
    }

    @Test
    void sumAll() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int expected = 1 + 2 + 3 + 4 + 5;
        assertEquals(expected, Streams.sumAll(numbers));
    }
}