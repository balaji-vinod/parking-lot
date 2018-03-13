package com.parking.threads;

import java.util.Scanner;

import com.parking.actions.ParkingLotActions;
import com.parking.manager.ParkingLotManager;

public class ParkingLotThread implements Runnable {

	@SuppressWarnings("resource")
	@Override
	public void run() {
		ParkingLotActions parkingLotActions = new ParkingLotActions(ParkingLotManager.getInstance());
		Scanner scanner = new Scanner(System.in);
		String input = "";
		String carNo = "";
		String reservation = "";
		boolean exitFlag = false;
		while(!exitFlag) {
			System.out.println("\n---------\nParking Lot Options:\n"
					+ "1) Display Parking Lot details\n"
					+ "2) Park Car\n"
					+ "3) Drive out\n"
					+ "4) Display report\n"
					+ "0) Exit Application\n");
			input = scanner.nextLine();
			switch(input) {
			case "1":
				parkingLotActions.displayParkingDetails();
				break;
			case "2":
				System.out.println("Enter Car Number");
				carNo = scanner.nextLine();
				System.out.println("Has reservation y/n");
				reservation = scanner.nextLine();
				parkingLotActions.carDrivingIn(carNo, reservation.equalsIgnoreCase("y"));
				break;
			case "3":
				System.out.println("Enter Car Number");
				carNo = scanner.nextLine();
				parkingLotActions.carDrivingOut(carNo);
				break;
			case "4":
				parkingLotActions.displayReport();
				break;
			case "0":
				exitFlag = true;
				break;
			default:
				System.out.println("Enter a valid option");	
			}
		}
	}

}
