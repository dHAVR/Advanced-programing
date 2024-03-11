package com.dar_hav_projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the problem.
 */
public class Problem {
    private List<Depot> depots;
    private List<Vehicle> vehicles;
    private List<Client> clients;

    /**
     * Constructs a new Problem instance.
     */
    public Problem() {
        this.depots = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.clients = new ArrayList<>();
    }
    
    /**
     * Adds a depot to the problem if it doesn't already exist.
     * 
     */
    public void addDepot(Depot depot) {
        if (!depots.contains(depot)) {
            depots.add(depot);
        }
    }

    /**
     * Adds a vehicle to the problem if it doesn't already exist.
     * 
     */
    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    /**
     * Adds a client to the problem if it doesn't already exist.
     * 
     */
    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    /**
     * Retrieves all vehicles from all depots.
     *
     * @return An array of all vehicles from all depots.
     */
    public Vehicle[] getVehicles() {
        return vehicles.toArray(new Vehicle[0]);
    }
    
    /**
     * Allocates clients to vehicles using a simple greedy algorithm.
     */
    public void allocateClients() {
        // Sorting vehicles by their capacity in descending order
        vehicles.sort((v1, v2) -> {
            //I use lambda expression to provide a short and simple expression for comparing two objects of type
            if (v1 instanceof Truck && v2 instanceof Truck) {
            	//return a positive number if it is true and negative if false
                return ((Truck) v2).getCapacity() - ((Truck) v1).getCapacity();
            } else {
                return 0; // If vehicles are not trucks, maintain the order
            }
        });

    	// Assign the client to the first available vehicle
        for (Client client : clients) {
            for (Vehicle vehicle : vehicles) {
         //looking for instances of Track
               if(vehicle instanceof Truck && ((Truck) vehicle).getCapacity()!=0) {
            	   System.out.println("Client " + client.getName() + " allocated to vehicle " + vehicle.getId());
            	   //Subtraction from capacity of particular track in order to prevent from congestion 
            	   ((Truck) vehicle).setCapacity(((Truck) vehicle).getCapacity() - 1);
                   break;
               }else {
            	//if it's not an instance of Track we just continue the loop work
            	   continue;
               }
            	
            }
        }
        
    }

}