package com.lca.phx.interview.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ParkingSpaceTest {

	ParkingSpace space;
	
	@Before
	public void setup () {
		this.space = null; //TODO Init space here
	}
	
	@Test
	public void testIsOccupied() {
		
		assertFalse(space.isOccupied());
		space.park(getVehicleStub());
		assertTrue(space.isOccupied());
		
	}

	@Test
	public void testPark() {

		assertTrue(space.park(getVehicleStub()) > 0);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParkForSpaceAlreadyOccupied() {
		
		space.park(getVehicleStub());
		space.park(getVehicleStub());
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParkForVehicleTooBig() {
		
		// Attempt to park a large vehicle in a small space
		ParkingSpace space = null; //TODO Init to a "compact" space
		space.park(getFullSizeVehicleStub());
		
	}


	@Test
	public void testRetrieveVehicle() {
		
		Vehicle v = getVehicleStub();
		space.park(v);
		Vehicle retrievedVehicle = space.retrieveVehicle();
		assertNotNull(retrievedVehicle);
		assertEquals(v, retrievedVehicle);
	}

	@Test
	public void testRetrieveVehicleForEmptySpace() {
		
		assertNull(space.retrieveVehicle());

	}
	
	
	// Stub Factory Methods
	private Vehicle getVehicleStub() {
		return getCompactSizeVehicleStub();
	}

	private Vehicle getFullSizeVehicleStub() {
		//TODO return "full size" Vehicle implementation
		return null;
	}

	private Vehicle getCompactSizeVehicleStub() {
		// TODO return "compace size" vehicle impl
		return null;
	}
}
