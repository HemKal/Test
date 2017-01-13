package com.lca.phx.interview.garage;

public class GarageDriver {

	
	public static void main(String[] args) {
		
		
		Garage garage = GarageImpl.init();
		
		System.out.println(garage);
		
		Vehicle v1 = new Vehicle(VehicleSize.Compact);
		Vehicle v2 = new Vehicle(VehicleSize.Compact);
		Vehicle v3 = new Vehicle(VehicleSize.Full);
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
