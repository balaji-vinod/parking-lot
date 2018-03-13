package com.parking.command.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.parking.command.ParkingCommand;
import com.parking.model.Car;

public class GenerateReport implements ParkingCommand {
	
	private List<Car> cars;
	Long totalFare;
	Date startDate;
	Date endDate;
	
	public GenerateReport(List<Car> cars) {
		this.cars = cars;
		totalFare = 0L;
		startDate = null;
		endDate = null;
	}

	@Override
	public void execute() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date today = new Date();
			String todayStr = dateFormatter.format(today);
			dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			startDate = dateFormatter.parse(todayStr+" 08:00");
			endDate = dateFormatter.parse(todayStr+" 22:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Cars Parked between 8am and 10pm");
		cars.forEach(car -> {
			if(!car.isParked() && car.getParkingStartTime().after(startDate) && car.getParkingEndTime().before(endDate)) {
				System.out.println(car);
				totalFare += car.getTotalFare();
			}
		});
		System.out.println("Total fare of cars parked between 8am and 10pm :"+totalFare);
	}

}
