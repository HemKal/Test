package com.lca.phx.interview.garage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GarageImpl implements Garage {

	private static final int DEFAULT_COMPACT_COUNT = 20;
	private static final int DEFAULT_FULL_COUNT = 20;
	
	
	private Map<Long, ParkingSpaceImpl> compactSpaces;
	private Map<Long, ParkingSpaceImpl> fullSizeSpaces;
	private int compactSpacesAvailable;
	private int fullSizeSpacesAvailable;
	
	private GarageImpl(int numOfCompactSpaces, int numOfFullSizeSpaces) {
		
		this.compactSpacesAvailable = numOfCompactSpaces;
		this.compactSpaces = new HashMap<Long, ParkingSpaceImpl>(numOfCompactSpaces);
		for (long i = 0; i < numOfCompactSpaces; i++) {
			compactSpaces.put(i, new ParkingSpaceImpl(i, VehicleSize.Compact));
		}
		
		this.fullSizeSpacesAvailable = numOfCompactSpaces;
		this.fullSizeSpaces = new HashMap<Long, ParkingSpaceImpl>(numOfFullSizeSpaces);
		for (long i = numOfCompactSpaces, totalSpaces = numOfCompactSpaces+numOfFullSizeSpaces; i < totalSpaces; i++) {
			fullSizeSpaces.put(i, new ParkingSpaceImpl(i, VehicleSize.Full));
		}
	
	}
	
	public static GarageImpl initWith(int numOfCompactSpaces, int numOfFullSizeSpaces) {
		return new GarageImpl(numOfCompactSpaces, numOfFullSizeSpaces);
	}

	public static GarageImpl init() {
		return initWith(DEFAULT_COMPACT_COUNT, DEFAULT_FULL_COUNT);
	}

	@Override
	public Ticket park(Vehicle v) {
		// Validate Vehicle;

		if (v.getSize() == VehicleSize.Compact) {
			for (ParkingSpace space : compactSpaces.values()) {
				if (!space.isOccupied()) {
					compactSpacesAvailable--;
					return new Ticket(space.park(v));
				}
			}
		}
		// If we got here either Vehicle was full size or was compact but no spaces available
		for (ParkingSpace space : fullSizeSpaces.values()) {
			if (!space.isOccupied()) {
				fullSizeSpacesAvailable--;
				return new Ticket(space.park(v));
			}
		}
		// No spaces available
		return null;
	}

	@Override
	public Vehicle retrieveVehicle(Ticket t) {
		// Validate Ticket
		if (compactSpaces.containsKey(t.getSpaceId())) {
			compactSpacesAvailable++;
			return compactSpaces.get(t.getSpaceId()).unPark();
		}
		
		if (fullSizeSpaces.containsKey(t.getSpaceId())) {
			fullSizeSpacesAvailable++;
			return fullSizeSpaces.get(t.getSpaceId()).unPark();
		}
		
		//callTheCopsCuzSombodiesCarHasBeenStolen();
		return null;
	}
	
	@Override
	public int totalSpacesAvailable() {
		return compactSpacesAvailable + fullSizeSpacesAvailable;
	}

	@Override
	public int spacesAvailableByType(VehicleSize size) {

		return (size == VehicleSize.Compact) ? compactSpacesAvailable : fullSizeSpacesAvailable;
	}

	@Override
	public String toString() {

		return new StringBuilder()
			.append("Garage Details: ")
			.append("\nTotal Compact Size Spaces: ").append(compactSpaces.size())
			.append("(").append(compactSpacesAvailable).append(" available)")
			.append("\nTotal Full Size Spaces: ").append(fullSizeSpaces.size())
			.append("(").append(fullSizeSpacesAvailable).append(" available)")
			.toString();
	}
	
	
	
}
