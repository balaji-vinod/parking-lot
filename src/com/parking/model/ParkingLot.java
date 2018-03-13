package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private static List<Floor> floors;
	private static ParkingLot parkingLot;
	private String nextSlot;
	private boolean parkingLotFull;

	private ParkingLot(List<Floor> floors, boolean parkingLotFull) {
		super();
		ParkingLot.floors = floors;
		this.parkingLotFull = parkingLotFull;
	}
	
	public synchronized static ParkingLot getInstance() {
		if(parkingLot == null) {
			parkingLot = createParkingLot();
		}
		return parkingLot;
	}

	private static ParkingLot createParkingLot() {
		floors = new ArrayList<>();
		floors.add(new Floor("1", createParkingSlots(), false));
		floors.add(new Floor("2", createParkingSlots(), false));
		floors.add(new Floor("3", createParkingSlots(), false));
		return new ParkingLot(floors, false);
	}

	private static List<ParkingSlot> createParkingSlots() {
		List<ParkingSlot> parkingSlots = new ArrayList<>();
		parkingSlots.add(new ParkingSlot("1", true, true));
		parkingSlots.add(new ParkingSlot("2", true, true));
		parkingSlots.add(new ParkingSlot("3", true, false));
		parkingSlots.add(new ParkingSlot("4", true, false));
		parkingSlots.add(new ParkingSlot("5", true, false));
		parkingSlots.add(new ParkingSlot("6", true, false));
		parkingSlots.add(new ParkingSlot("7", true, false));
		parkingSlots.add(new ParkingSlot("8", true, false));
		parkingSlots.add(new ParkingSlot("9", true, false));
		parkingSlots.add(new ParkingSlot("10", true, false));
		return parkingSlots;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public String getNextSlot() {
		return nextSlot;
	}

	public void setNextSlot(String nextSlot) {
		this.nextSlot = nextSlot;
	}

	public boolean isParkingLotFull() {
		return parkingLotFull;
	}

	public void setParkingLotFull(boolean parkingLotFull) {
		this.parkingLotFull = parkingLotFull;
	}
	
}
