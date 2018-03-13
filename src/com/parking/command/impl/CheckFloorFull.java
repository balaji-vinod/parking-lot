package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Floor;
import com.parking.model.ParkingLot;
import com.parking.model.ParkingSlot;

public class CheckFloorFull implements ParkingCommand {
	
	private ParkingLot parkingLot;
	
	public CheckFloorFull() {
		parkingLot = ParkingLot.getInstance();
	}


	@Override
	public void execute() {
		boolean parkingLotFull = true;
		for(Floor floor: parkingLot.getFloors()) {
			boolean floorFull = true;
			if(!floor.isFloorFull()) {
				for(ParkingSlot parkingSlot : floor.getParkingSlots()) {
					if(parkingSlot.isAvailable()) {
						floorFull = false;
						break;
					}
				}
				if(floorFull) {
					System.out.println("Floor "+floor.getFloorNo()+" is full");
					floor.setFloorFull(floorFull);
				}
			}
			if(!floor.isFloorFull()) {
				parkingLotFull = false;
			}
		}
		if(parkingLotFull) {
			System.out.println("Parking Lot is full");
			parkingLot.setParkingLotFull(parkingLotFull);
		}
	}

}
