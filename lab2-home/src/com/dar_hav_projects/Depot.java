package com.dar_hav_projects;

import java.util.Objects;


/**
 * Represents a depot.
 */
class Depot {
	
    private final String name;

    public Depot(String name) {
        this.name = name;
    }


    public String getName() {
		return name;
	}

    /**
     * Overrides the equals method to compare Depot objects based on their names.
     */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}