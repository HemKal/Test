package com.lca.phx.interview.garage;

/**
 * Stub factory that to easily get new Vehicle instances
 */
public class VehicleStubFactory {

	private static Vehicle buildVehicleOfSize(VehicleSize size) {
		//TODO Return vehicle of the size provided
		return null;
	}
	
	public static Vehicle buildCompactVehicle() {
		return buildVehicleOfSize(VehicleSize.Compact);
	}

	public static Vehicle buildFullSizeVehicle() {
		return buildVehicleOfSize(VehicleSize.Full);
	}
	
}
