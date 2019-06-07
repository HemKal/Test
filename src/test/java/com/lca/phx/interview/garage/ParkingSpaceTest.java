package com.lca.phx.interview.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ParkingSpaceTest {

	private ParkingSpace space;
	private long SPACE_ID = 10;
	
	
	@Before
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

	@Test(expected=IllegalArgumentException.class)
	public void testParkForSpaceAlreadyOccupied() {
		
		Vehicle v1 = VehicleStubFactory.buildCompactVehicle();
		space.park(v1);
		
		Vehicle v2 = VehicleStubFactory.buildCompactVehicle();
		space.park(v2);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParkForVehicleTooBig() {
		
		// Attempt to park a large vehicle in a small space
		ParkingSpace space = null; //TODO Init to a "compact" space
		space.park(VehicleStubFactory.buildFullSizeVehicle());
		
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
