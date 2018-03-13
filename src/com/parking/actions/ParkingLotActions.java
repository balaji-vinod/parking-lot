package com.parking.actions;

import com.parking.manager.ParkingLotManager;

public class ParkingLotActions {
	
	private ParkingLotManager parkingLotManager;
	
	public ParkingLotActions(ParkingLotManager parkingLotManager) {
		this.parkingLotManager = parkingLotManager;
	}
	
	public void carDrivingIn(String carNo, boolean reservation) {
		System.out.println("--- CarParking started----");
		try {
			parkingLotManager.driveIn(carNo, reservation);
			parkingLotManager.findNextAvailabeParkingSpace(carNo);
			parkingLotManager.parkCar(carNo);
			parkingLotManager.checkFloorFull();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			if(ParkingLotManager.getCarMap().containsKey(carNo)) {
				ParkingLotManager.getCarMap().remove(carNo);
			}
		}
		
		System.out.println("--- CarParking Ended----");
	}
	
	public void carDrivingOut(String carNo) {
		System.out.println("--- Car driving out started----");
		try {
			parkingLotManager.driveOut(carNo);
			parkingLotManager.freeParkingSpace(carNo);
			ParkingLotManager.getCarMap().remove(carNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
		System.out.println("--- Car driving out Ended----");
	}
	
	public void displayParkingDetails() {
		try {
			parkingLotManager.displayParkingDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayReport() {
		try {
			parkingLotManager.displayReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
