package com.lca.phx.interview.garage;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParkingSpaceTest {

	private ParkingSpace space;
	private long SPACE_ID = 10;
	
	
	@BeforeEach
	public void setup () {
		this.space = null; //TODO Init space here
	}
	
	@Test
	public void testIsOccupied() {
		
		assertFalse(space.isOccupied());
		space.park(VehicleStubFactory.buildCompactVehicle());
		assertTrue(space.isOccupied());
		space.retrieveVehicle();
		assertFalse(space.isOccupied());
		
	}

	@Test
	public void testParkCompact() {

		assertEquals(SPACE_ID, space.park(VehicleStubFactory.buildCompactVehicle()));
		
	}

	@Test
	public void testParkFullSize() {
		
		assertEquals(SPACE_ID, space.park(VehicleStubFactory.buildFullSizeVehicle()));
		
	}

	@Test()
	public void testParkForSpaceAlreadyOccupied() {
		
		Vehicle v1 = VehicleStubFactory.buildCompactVehicle();
		space.park(v1);
		
		Vehicle v2 = VehicleStubFactory.buildCompactVehicle();
		
		assertThatIllegalArgumentException()
			.isThrownBy(()->{space.park(v2);});
		
		
	}

	@Test()
	public void testParkForVehicleTooBig() {
		
		// Attempt to park a large vehicle in a small space
		ParkingSpace space = null; //TODO Init to a "compact" space
		assertThatIllegalArgumentException()
			.isThrownBy(()->{space.park(VehicleStubFactory.buildFullSizeVehicle());});
		
	}


	@Test
	public void testRetrieveVehicle() {
		
		Vehicle v = VehicleStubFactory.buildCompactVehicle();
		space.park(v);
		Vehicle retrievedVehicle = space.retrieveVehicle();
		assertNotNull(retrievedVehicle);
		assertEquals(v, retrievedVehicle);
	}

	@Test
	public void testRetrieveVehicleForEmptySpace() {
		
		assertNull(space.retrieveVehicle());

	}

}
