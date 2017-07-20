package com.workshop.app.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.workshop.app.impl.Service;

public class ServiceDao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Service service){
		String query = "INSERT INTO service(registrationNumber, price, carID, customerID) VALUES('" 
				+ service.getRegistrationNumber() + "', " + service.getPrice() + ", " + service.getCarID() + ", "
				+ service.getCustomerID() + ")";
		return template.update(query);
	}

}
