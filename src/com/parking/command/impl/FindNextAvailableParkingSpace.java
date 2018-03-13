package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Floor;
import com.parking.model.ParkingLot;
import com.parking.model.ParkingSlot;

public class FindNextAvailableParkingSpace implements ParkingCommand {
	
	private ParkingLot parkingLot;
	
	public FindNextAvailableParkingSpace() {
		parkingLot = ParkingLot.getInstance();
	}

	@Override
	public void execute() throws Exception {
		parkingLot.setNextSlot("");
		if(parkingLot.isParkingLotFull()) {
			throw new Exception("Parking Lot is full");
		}
		boolean slotFound = false;
		for(Floor floor: parkingLot.getFloors()) {
			if(floor.isFloorFull()) {
				continue;
			}
			for(ParkingSlot parkingSlot : floor.getParkingSlots()) {
				if(!parkingSlot.isReserved() && parkingSlot.isAvailable()) {
					parkingLot.setNextSlot(floor.getFloorNo()+"-"+parkingSlot.getParkingSlotNo());
					slotFound = true;
					break;
				}
			}
			if(slotFound) {
				break;
			}
		}
	}

}
