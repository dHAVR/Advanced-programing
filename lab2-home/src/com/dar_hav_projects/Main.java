package com.dar_hav_projects;

import com.dar_hav_projects.*;

public class Main {

	public static void main(String[] args) {
		// Creating depots, vehicles, and clients
        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");

        Truck truck1 = new Truck("Truck 1", 1);
        Truck truck2 = new Truck("Truck 2", 2);
        Drone drone1 = new Drone("Drone 1", 120);
        Drone drone2 = new Drone("Drone 2", 180);
        Drone drone3 = new Drone("Drone 2", 180);

        Client client1 = new Client("Client 1", ClientType.REGULAR);
        Client client2 = new Client("Client 2", ClientType.PREMIUM);
        Client client3 = new Client("Client 3", ClientType.REGULAR);

        // Creating a problem instance
        Problem problem = new Problem();

        // Adding depots, vehicles, and clients to the problem
        problem.addDepot(depot1);
        problem.addDepot(depot2);
        problem.addVehicle(truck1);
        problem.addVehicle(truck2);
        problem.addVehicle(drone1);
        problem.addVehicle(drone2);
        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);

        // Retrieving all vehicles
        Vehicle[] allVehicles = problem.getVehicles();
        System.out.println("All vehicles:");
        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle.getId());
        }
        
        problem.allocateClients();
	}

}
