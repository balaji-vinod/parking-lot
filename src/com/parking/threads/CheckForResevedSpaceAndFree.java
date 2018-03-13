package com.parking.threads;

import com.parking.model.ParkingLot;

public class CheckForResevedSpaceAndFree implements Runnable {
	
	private ParkingLot parkingLot;
	
	public CheckForResevedSpaceAndFree() {
		parkingLot = ParkingLot.getInstance();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(60000L);
			System.out.println("Checking for reseved space and freeingup");
			parkingLot.getFloors().forEach(floor -> {
				floor.getParkingSlots().forEach(parkingSlot -> {
					if(parkingSlot.isReserved()) {
						parkingSlot.setReserved(false);
					}
				});
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
