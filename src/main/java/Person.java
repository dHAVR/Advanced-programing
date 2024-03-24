
class Person {
    private String name;
    private String destination;

    public Person(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return name + " -> " + destination;
    }
}