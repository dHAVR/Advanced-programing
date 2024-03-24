
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
public class CarpoolingProblem {
    private List<Person> drivers;
    private List<Person> passengers;

    public CarpoolingProblem(int numDrivers, int numPassengers) {
        Faker faker = new Faker();

        drivers = new ArrayList<>();
        passengers = new ArrayList<>();

        // Generate random names for drivers and passengers
        for (int i = 0; i < numDrivers; i++) {
            drivers.add(new Person(faker.name().fullName(), faker.address().city()));
        }
        drivers.add(new Person("Petro1", "Lviv"));
        for (int i = 0; i < numPassengers; i++) {
            passengers.add(new Person(faker.name().fullName(), faker.address().city()));
        }
        passengers.add(new Person("Petro2", "Lviv"));
    }

    // Compute a list of all the destinations that the drivers pass through
    public List<String> destinationsPassedByDrivers() {
        return drivers.stream()
                .map(Person::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    // Compute a map of destinations and people who want to go there
    public Map<String, List<Person>> peopleForDestinations() {
        Map<String, List<Person>> destinationMap = new HashMap<>();
        passengers.forEach(passenger -> destinationMap
                .computeIfAbsent(passenger.getDestination(), k -> new ArrayList<>())
                .add(passenger));
        return destinationMap;
    }

    // Greedy algorithm to match drivers and passengers
    public Map<Person, Person> match() {
        Map<Person, Person> matches = new HashMap<>();
        List<Person> unmatchedPassengers = new ArrayList<>(passengers);

        for (Person driver : drivers) {
            String destination = driver.getDestination();
            List<Person> potentialPassengers = passengers.stream()
                    .filter(p -> p.getDestination().equals(destination))
                    .collect(Collectors.toList());
            if (!potentialPassengers.isEmpty()) {
                Person passenger = potentialPassengers.get(0); // Greedy approach, just pick the first one
                matches.put(driver, passenger);
                unmatchedPassengers.remove(passenger);
            }
        }

        System.out.println("Matched pairs:");
        matches.forEach((driver, passenger) -> System.out.println(driver.getName() + " -> " + passenger.getName()));

        System.out.println("\nUnmatched passengers:");
        unmatchedPassengers.forEach(passenger -> System.out.println(passenger.getName()));

        return matches;
    }
}