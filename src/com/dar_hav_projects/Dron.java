package com.dar_hav_projects;


/**
 * Represents a drone.
 */
class Drone extends Vehicle {
    private final int maxFlightDuration;

    public Drone(String id, int maxFlightDuration) {
        super(id);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }
}
