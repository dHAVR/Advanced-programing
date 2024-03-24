
import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        CarpoolingProblem problem = new CarpoolingProblem(5, 5);
        System.out.println("Destinations passed by drivers: " + problem.destinationsPassedByDrivers());
        System.out.println("\nPeople for destinations:");
        problem.peopleForDestinations().forEach((destination, people) -> {
            System.out.println(destination + ":");
            people.forEach(System.out::println);
        });

        System.out.println("\nMatching drivers and passengers:");
        problem.match();
    }
}
