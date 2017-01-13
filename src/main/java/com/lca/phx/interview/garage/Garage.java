package com.lca.phx.interview.garage;

public interface Garage {

	Ticket park(Vehicle v);
	Vehicle retrieveVehicle(Ticket t);
	int totalSpacesAvailable();
	int spacesAvailableByType(VehicleSize size);
	
}
