package com.lca.phx.interview.garage;

public class GarageDriver {

	/**
	 * Driver Program to exercise Garage Class
	 * 
	 * 1) Create Instance of Garage class and print out it's state
	 * 2) Create a couple car instances of different sizes and park them
	 * 3) Print out state of garage
	 * 4) retrieve previously parked cars
	 * 5) Print out state of garage
	 */
	public static void main(String[] args) {
		
		//TODO Initialize Garage
		Garage garage = null;
		
		System.out.println(garage);
		
		//TODO Init a few Vehicles of different sizes;
		Vehicle v1 = null;
		Vehicle v2 = null;
		Vehicle v3 = null;
		System.out.printf("Vehicles to park: v1: %s, v2: %s, V3: %s", v1, v2, v3);

		Ticket t1 = garage.park(v1);
		Ticket t2 = garage.park(v2);
		Ticket t3 = garage.park(v3);
		System.out.printf("\nTickets of parked vehicles: t1: %s, t2: %s, t3: %s", t1, t2, t3);
		
		System.out.println(garage);
		
		Vehicle vv1 = garage.retrieveVehicle(t1);
		Vehicle vv2 = garage.retrieveVehicle(t2);
		Vehicle vv3 = garage.retrieveVehicle(t3);
		System.out.printf("\nRetrieved vehicles: v1: %s, v2: %s, v3: %s", vv1, vv2, vv3);
		
		System.out.println(garage);
		
	}
}
