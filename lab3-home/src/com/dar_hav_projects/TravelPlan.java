package com.dar_hav_projects;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class TravelPlan {
    private Map<LocalDate, Attraction> plan;

    public TravelPlan() {
        plan = new HashMap<>();
    }

    public void addVisit(LocalDate date, Attraction attraction) {
        plan.put(date, attraction);
    }

    public void printPlan() {
        System.out.println("Travel Plan:");
        for (Map.Entry<LocalDate, Attraction> entry : plan.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
    }
}
