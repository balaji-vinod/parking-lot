package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Car;
import com.parking.model.ParkingLot;

public class FreeParkingSpace implements ParkingCommand {
	
	private ParkingLot parkingLot;
	private Car car;
	
	public FreeParkingSpace(Car car) {
		this.car = car;
		parkingLot = ParkingLot.getInstance();
	}

	@Override
	public void execute() {
		String[] parkedSpace = car.getParkedAt().split("-");
		parkingLot.getFloors().get(Integer.valueOf(parkedSpace[0])-1).getParkingSlots().get(Integer.valueOf(parkedSpace[1])-1).setAvailable(true);
		parkingLot.getFloors().get(Integer.valueOf(parkedSpace[0])-1).setFloorFull(false);
		parkingLot.setParkingLotFull(false);
	}

}
