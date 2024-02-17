package dns.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    public static final Person SARA = new Person("Sara", 4, "Norwegian");
    public static final Person VIKTOR = new Person("Viktor", 40, "Serbian");
    public static final Person EVA = new Person("Eva", 42, "Norwegian");
    public static final Person ANNA = new Person("Anna", 5);

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
        List<Person> people = List.of(SARA, EVA, VIKTOR);
        Person result = Streams.getOldestPerson(people);
        assertEquals(EVA, result);
    }

    @Test
    void sumAll() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int expected = 1 + 2 + 3 + 4 + 5;
        assertEquals(expected, Streams.sumAll(numbers));
    }

    @Test
    public void getKidNameShouldReturnNamesOfAllKidsUnder18() {
        List<Person> collection = List.of(SARA, EVA, VIKTOR, ANNA);
        Set<String> result = Streams.getKidNameShouldReturnNamesOfAllKidsUnder18(collection);
        assertEquals(Set.of("Sara", "Anna"), result);
    }

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        List<Person> collection = List.of(SARA, EVA, VIKTOR);
        Map<Boolean, List<Person>> result = Streams.partitionAdults(collection);
        assertEquals(List.of(EVA, VIKTOR), result.get(true));
        assertEquals(List.of(SARA), result.get(false));
    }

    @Test
    public void groupByNationality() {
        List<Person> collection = List.of(SARA, EVA, VIKTOR);
        Map<String, List<Person>> result = Streams.groupByNationality(collection);
        assertEquals(List.of(SARA, EVA), result.get("Norwegian"));
        assertEquals(List.of(VIKTOR), result.get("Serbian"));
    }

    @Test
    public void joinNamesSeparatedByString() {
        List<Person> collection = List.of(SARA, VIKTOR, EVA);
        String result = Streams.joinNamesSeparatedByString(collection);
        assertEquals("Names: Sara,Viktor,Eva.", result);
    }

    @Test
    public void shouldOutputEvenUnevenString() {
        assertEquals("o3,e44", Streams.getEvenOrOdd(List.of(3,44)));
        assertEquals("o5,e2,e100", Streams.getEvenOrOdd(List.of(5,2,100)));
    }
}