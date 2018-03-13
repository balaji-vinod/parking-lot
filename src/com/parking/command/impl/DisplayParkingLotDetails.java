package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Floor;
import com.parking.model.ParkingLot;
import com.parking.model.ParkingSlot;

public class DisplayParkingLotDetails implements ParkingCommand {
	
	private ParkingLot parkingLot;
	
	public DisplayParkingLotDetails() {
		parkingLot = ParkingLot.getInstance();
	}

	@Override
	public void execute() {
		if(parkingLot.isParkingLotFull()) {
			System.out.println("Parking Lot is full");
			return;
		}
		for(Floor floor: parkingLot.getFloors()) {
			System.out.println(floor);
			if(floor.isFloorFull()) {
				continue;
			}
			for(ParkingSlot parkingSlot : floor.getParkingSlots()) {
				System.out.println(parkingSlot);
			}
		}
	}

}
