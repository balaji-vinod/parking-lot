package com.parking.command.impl;

import com.parking.command.ParkingCommand;
import com.parking.model.Car;

public class DriveOut implements ParkingCommand{
	
	private Car car;
	
	public DriveOut(Car car) {
		this.car = car;
	}
	

	@Override
	public void execute() {
		car.driveOut();
	}

}
