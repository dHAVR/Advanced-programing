package com.dar_hav_projects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Trip {
    private List<Attraction> attractions;

    public Trip() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void displayVisitableNotPayable() {
        List<Attraction> visitableNotPayable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            // Assuming there's a method isPayable() in Attraction class
            if (!attraction.isPayable) {
                visitableNotPayable.add(attraction);
            }
        }

        visitableNotPayable.sort(Comparator.comparing(attraction -> attraction.getOpeningHour(LocalDate.now())));

        System.out.println("Visitable and not payable attractions sorted by opening hour:");
        for (Attraction attraction : visitableNotPayable) {
            System.out.println(attraction.getName() + " - Opening Hour: " + attraction.getOpeningHour(LocalDate.now()));
        }
    }
}
