package com.lca.phx.interview.garage;

public interface Garage {

	/**
	 * Given a {@link Vehicle} instance, parks provided car in garage and returns a {@link Ticket} that can be used to retrieve car.
	 * @param v {@link Vehicle} that needs to be parked
	 * @return {@link Ticket} intance that can be used to subsequently used to retrieve parked {@link Vehicle}.
	 * @see Garage#retrieveVehicle(Ticket)
	 */
	Ticket park(Vehicle v);
	
	/**
	 * Method used to retrieve a previously parked {@link Vehicle} from this {@link Garage}
	 * @param t The {@link Ticket} associated with the previoulsy parked car
	 * @return The {@link Vehicle} associated with the supplied Ticket
	 * @see Garage#park(Vehicle)
	 */
	Vehicle retrieveVehicle(Ticket t);
	
	/**
	 * Returns back the total # of unoccupied spaces available, regardless of size
	 */
	int totalSpacesAvailable();
	/**
	 * Returns the number of spaces available for the given {@link VehicleSize}. 
	 */
	int spacesAvailableByType(VehicleSize size);

	/**
	 * Returns a string representation of the current state of the garage e.g. How many spaces are available/occupied.
	 */
	String getGarageState();
	
}
