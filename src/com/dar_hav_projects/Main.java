package com.dar_hav_projects;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
        Attraction museum = new Attraction("National Museum", true);
        museum.addVisitingTime(LocalDate.of(2024, 3, 22), LocalTime.of(9, 0), LocalTime.of(17, 0));

        Attraction park = new Attraction("Central Park", false);
        park.addVisitingTime(LocalDate.of(2024, 3, 22), LocalTime.of(7, 0), LocalTime.of(22, 0));

        Trip trip = new Trip();
        trip.addAttraction(museum);
        trip.addAttraction(park);

        trip.displayVisitableNotPayable();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(LocalDate.of(2024, 3, 22), museum);
        travelPlan.addVisit(LocalDate.of(2024, 3, 23), park);

        travelPlan.printPlan();
    }
}
