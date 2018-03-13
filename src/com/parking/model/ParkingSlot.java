package com.parking.model;

public class ParkingSlot {
	
	private String parkingSlotNo;
	private boolean available;
	private boolean reserved;
	
	public ParkingSlot() {
		super();
	}
	
	public ParkingSlot(String parkingSlotNo, boolean available, boolean reserved) {
		super();
		this.parkingSlotNo = parkingSlotNo;
		this.available = available;
		this.reserved = reserved;
	}
	public String getParkingSlotNo() {
		return parkingSlotNo;
	}
	public void setParkingSlotNo(String parkingSlotNo) {
		this.parkingSlotNo = parkingSlotNo;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Parking Slot No: "+parkingSlotNo+" is "+(available ? "available":"occoupied")+(reserved ? " and reserved ":"");
	}
}
