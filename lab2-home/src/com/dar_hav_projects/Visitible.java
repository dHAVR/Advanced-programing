package com.dar_hav_projects;

import java.time.LocalDate;
import java.time.LocalTime;

interface Visitable {
    LocalTime getOpeningHour(LocalDate date);
}