package com.workshop.app.impl;

public class Customer {

	private int customerID;
	private String firstName;
	private String secondName;
	private String phoneNumber;
	private int workshopID;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getWorkshopID() {
		return workshopID;
	}

	public void setWorkshopID(int workshopID) {
		this.workshopID = workshopID;
	}

}
