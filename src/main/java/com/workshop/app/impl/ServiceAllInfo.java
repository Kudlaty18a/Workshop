package com.workshop.app.impl;

public class ServiceAllInfo extends Service {
	
	private Car car;
	private Customer customer;
	
	public ServiceAllInfo(){
		car = new Car();
		customer = new Customer();
	}
	
	public void setBrand(String brand){
		car.setBrand(brand);
	}
	
	public String getBrand(){
		return car.getBrand();
	}
	
	public void setModel(String model){
		car.setModel(model);
	}
	
	public String getModel(){
		return car.getModel();
	}
	
	public void setYear(String year){
		car.setYear(year);
	}
	
	public String getYear(){
		return car.getYear();
	}
	
	public void setFirstName(String firstName){
		customer.setFirstName(firstName);
	}
	
	public String getFirstName(){
		return customer.getFirstName();
	}
	
	public void setSecondName(String secondName){
		customer.setSecondName(secondName);
	}
	
	public String getSecondName(){
		return customer.getSecondName();
	}
	
	public void setPhoneNumber(String phoneNumber){
		customer.setPhoneNumber(phoneNumber);
	}
	
	public String getPhoneNumber(){
		return customer.getPhoneNumber();
	}
	
}
