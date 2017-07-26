package com.workshop.app.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionHistory {
	
	private int actionHistoryID;
	private Date actionDate;
	private String operation;
	private double price;
	private int serviceID;
	private SimpleDateFormat sdf;
	
	public ActionHistory(){
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public int getActionHistoryID() {
		return actionHistoryID;
	}

	public void setActionHistoryID(int actionHistoryID) {
		this.actionHistoryID = actionHistoryID;
	}

	public SimpleDateFormat getActionDate() {
		sdf.format(actionDate);
		return sdf;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	
}
