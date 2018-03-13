package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Car;
import com.parking.model.ParkingLot;

public class ParkCar implements ParkingCommand {
	
	private ParkingLot parkingLot;
	private Car car;
	
	public ParkCar(Car car) {
		parkingLot = ParkingLot.getInstance();
		this.car = car;
	}


	@Override
	public void execute() {
		String[] availabeSpace = parkingLot.getNextSlot().split("-");
		parkingLot.getFloors().get(Integer.valueOf(availabeSpace[0])-1).getParkingSlots().get(Integer.valueOf(availabeSpace[1])-1).setAvailable(false);
		car.setParkedAt(parkingLot.getNextSlot());
	}

}
