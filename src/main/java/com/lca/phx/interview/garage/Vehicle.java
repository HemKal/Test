package com.lca.phx.interview.garage;

public class Vehicle {

	private VehicleSize size;
	
	public Vehicle(VehicleSize size) {
		super();
		this.size = size;
	}

	public VehicleSize getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [size=").append(size).append("]");
		return builder.toString();
	}
	
}
