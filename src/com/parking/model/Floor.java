package com.parking.model;

import java.util.List;

public class Floor {
	
	private String floorNo;
	private List<ParkingSlot> parkingSlots;
	private boolean floorFull;
	
	public Floor(String floorNo, List<ParkingSlot> parkingSlots, boolean floorFull) {
		super();
		this.floorNo = floorNo;
		this.parkingSlots = parkingSlots;
		this.floorFull = floorFull;
	}
	
	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}
	public void setParkingSlots(List<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	
	public boolean isFloorFull() {
		return floorFull;
	}
	public void setFloorFull(boolean floorFull) {
		this.floorFull = floorFull;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	@Override
	public String toString() {
		return "Floor No: "+floorNo+" is "+(floorFull ? " full ":" available ");
	}
}
