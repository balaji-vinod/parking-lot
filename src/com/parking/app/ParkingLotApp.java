package com.parking.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.parking.threads.CheckForResevedSpaceAndFree;
import com.parking.threads.ParkingLotThread;

public class ParkingLotApp {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new CheckForResevedSpaceAndFree());
		executorService.execute(new ParkingLotThread());
		
	}

}
