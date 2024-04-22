package com.dar_hav_projects;

import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;

class Attraction implements Visitable {
    private String name;
    private Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable;
    protected boolean isPayable = false;

    public Attraction(String name, boolean isPayable) {
        this.name = name;
        this.visitingTimetable = new HashMap<>();
        this.isPayable = isPayable;
    }

    public void addVisitingTime(LocalDate date, LocalTime openingHour, LocalTime closingHour) {
        visitingTimetable.put(date, new Pair<>(openingHour, closingHour));
    }

    @Override
    public LocalTime getOpeningHour(LocalDate date) {
        return visitingTimetable.get(date).getKey();
    }

    public String getName() {
        return name;
    }
}
