package com.parking.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parking.command.ParkingCommand;
import com.parking.command.impl.CheckFloorFull;
import com.parking.command.impl.DisplayParkingLotDetails;
import com.parking.command.impl.DriveIn;
import com.parking.command.impl.DriveOut;
import com.parking.command.impl.FindNextAvailableParkingSpace;
import com.parking.command.impl.FindReservedParkingSpace;
import com.parking.command.impl.FreeParkingSpace;
import com.parking.command.impl.GenerateReport;
import com.parking.command.impl.ParkCar;
import com.parking.model.Car;

public class ParkingLotManager {
	
	private ParkingCommand parkingCommand;
	private static ParkingLotManager parkingLotManager;
	private static Map<String, Car> carMap;
	private static List<Car> cars;
	
	private ParkingLotManager() {
		carMap = new HashMap<>();
		cars = new ArrayList<>();
	}
	
	public static ParkingLotManager getInstance() {
		if(parkingLotManager == null) {
			parkingLotManager = new ParkingLotManager();
		}
		return parkingLotManager;
	}
	
	public void driveIn(String carNo, boolean reservation) throws Exception {
		if(carMap.containsKey(carNo)) {
			throw new Exception("Car is already in parking lot");
		}
		Car car = new Car(carNo, reservation);
		parkingCommand = new DriveIn(car);
		parkingCommand.execute();
		carMap.put(carNo, car);
	}
	
	public void findNextAvailabeParkingSpace(String carNo) throws Exception {
		parkingCommand = carMap.get(carNo).isHasReservation() ? new FindReservedParkingSpace(): new FindNextAvailableParkingSpace();
		parkingCommand.execute();
	}
	
	public void parkCar(String carNo) throws Exception {
		parkingCommand = new ParkCar(carMap.get(carNo));
		parkingCommand.execute();
	}
	
	public void checkFloorFull() throws Exception {
		parkingCommand = new CheckFloorFull();
		parkingCommand.execute();
	}
	
	public void displayParkingDetails() throws Exception {
		parkingCommand = new DisplayParkingLotDetails();
		parkingCommand.execute();
	}
	
	public void driveOut(String carNo) throws Exception {
		if(!carMap.containsKey(carNo)) {
			throw new Exception("Car is not in parking lot or already left");
		}
		parkingCommand = new DriveOut(carMap.get(carNo));
		parkingCommand.execute();
		cars.add(carMap.get(carNo));
	}
	
	public void freeParkingSpace(String carNo) throws Exception {
		parkingCommand = new FreeParkingSpace(carMap.get(carNo));
		parkingCommand.execute();
	}

	public void displayReport() throws Exception {
		parkingCommand = new GenerateReport(cars);
		parkingCommand.execute();
	}

	public static Map<String, Car> getCarMap() {
		return carMap;
	}

	public static void setCarMap(Map<String, Car> carMap) {
		ParkingLotManager.carMap = carMap;
	}


}
