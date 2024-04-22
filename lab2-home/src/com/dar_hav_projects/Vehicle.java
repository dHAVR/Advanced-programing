package com.dar_hav_projects;

import java.util.Objects;


/**
 * Abstract class representing a vehicle.
 */
abstract class Vehicle {
    private final String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Overrides the equals method to compare Vehicle objects based on their ids.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
