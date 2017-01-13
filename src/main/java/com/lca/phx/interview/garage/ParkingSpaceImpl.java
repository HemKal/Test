package com.lca.phx.interview.garage;

public class ParkingSpaceImpl implements ParkingSpace {

	private long spaceId;
	private VehicleSize size;
	private Vehicle vehicle;
	
	public ParkingSpaceImpl(long id, VehicleSize size) {
		super();
		this.spaceId = id;
		this.size = size;
	}
	
	@Override
	public boolean isOccupied() {
		return this.vehicle != null;
	}
	
	@Override
	public long park(Vehicle v) {
		
		validate(v);
		this.vehicle = v;
		return this.spaceId;
		
	}

	@Override
	public Vehicle retrieveVehicle() {
		
		Vehicle v = this.vehicle;
		this.vehicle = null;
		return v;
		
	}

	protected void validate(Vehicle v) {

		if (v == null) {
			throw new IllegalArgumentException("Invalid vehicle supplied.  Null is not allowed.");
		}
		
		if (this.vehicle != null) {
			throw new IllegalArgumentException("Space is occupied.  Unable to park another Vehicle here");
		}
		
		if (this.size.compareTo(v.getSize()) > 0) {
			throw new IllegalArgumentException("Unable to park a car of size " + v.getSize() + " in a ParkingSpace of size " + this.size);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
		.append("ParkingSpace [size=").append(size)
		.append(", isOccupied: ").append(isOccupied());
		
		if (isOccupied()) {
			builder.append(", Vehicle: ").append(vehicle);
		}
		return builder.toString();
	}
	
	
	
}
