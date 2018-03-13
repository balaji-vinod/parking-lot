package com.parking.model;

import java.util.Date;

public class Car {
	
	private String carNumber;
	private Date parkingStartTime;
	private Date parkingEndTime;
	private boolean parked;
	private boolean hasReservation;
	private String parkedAt;
	
	public Car(String carNumber, boolean hasReservation) {
		super();
		this.carNumber = carNumber;
		this.hasReservation = hasReservation;
	}

	public Car(String carNumber, Date parkingStartTime, Date parkingEndTime, boolean parked, String parkedAt) {
		super();
		this.carNumber = carNumber;
		this.parkingStartTime = parkingStartTime;
		this.parkingEndTime = parkingEndTime;
		this.parked = parked;
		this.parkedAt = parkedAt;
	}

	public void driveIn() {
		parked = true;
		setParkingStartTime(new Date());
	}
	
	public void driveOut() {
		parked = false;
		setParkingEndTime(new Date());
		System.out.println("Total Fare :"+getTotalFare());
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Date getParkingStartTime() {
		return parkingStartTime;
	}

	public void setParkingStartTime(Date parkingStartTime) {
		this.parkingStartTime = parkingStartTime;
	}

	public Date getParkingEndTime() {
		return parkingEndTime;
	}

	public void setParkingEndTime(Date parkingEndTime) {
		this.parkingEndTime = parkingEndTime;
	}

	public boolean isParked() {
		return parked;
	}

	public void setParked(boolean parked) {
		this.parked = parked;
	}

	public Long getTotalFare() {
		Long totalFare = ((parkingEndTime.getTime() - parkingStartTime.getTime())/(1000*60*60))*50;
		return totalFare == 0 ? 50L : totalFare;
	}

	public String getParkedAt() {
		return parkedAt;
	}

	public void setParkedAt(String parkedAt) {
		this.parkedAt = parkedAt;
	}

	public boolean isHasReservation() {
		return hasReservation;
	}

	public void setHasReservation(boolean hasReservation) {
		this.hasReservation = hasReservation;
	}

	@Override
	public String toString() {
		return "Car :"+carNumber+"\nParked Between :"+parkingStartTime+" - "+parkingEndTime+"\nTotal Fare :"+getTotalFare();
	}


}
