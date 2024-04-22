package com.dar_hav_projects;

import java.util.Objects;

/**
 * Represents a client.
 */
public class Client {
	private ClientType type;
	private final String name;

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
    }

    public ClientType getType() {
		return type;
	}



	public void setType(ClientType type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}

    /**
     * Overrides the equals method to compare Client objects based on their names.
     */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

