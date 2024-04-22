package com.dar_hav_projects;


/**
 * Represents a truck.
 */
class Truck extends Vehicle {
    private int capacity;

    public Truck(String id, int capacity) {
        super(id);
        this.capacity = capacity;
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


}

