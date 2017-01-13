package com.lca.phx.interview.garage;

public interface ParkingSpace {

	public  boolean isOccupied();
	public  long park(Vehicle v);
	public  Vehicle retrieveVehicle();

}