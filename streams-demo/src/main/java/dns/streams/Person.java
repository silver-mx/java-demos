package dns.streams;

public record Person(String name, int age, String nationality) {

    public Person(String name, int age) {
        this(name, age, null);
    }
}
