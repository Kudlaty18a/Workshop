package com.workshop.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.workshop.app.impl.Service;
import com.workshop.app.impl.ServiceAllInfo;

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
	
	public List<ServiceAllInfo> getAllServices(){
		String query = "SELECT s.serviceID, s.registrationNumber, s.price, c.brand, c.model, c.year, "
				+ "cust.firstName, cust.secondName, cust.phoneNumber "
				+ "FROM service s " 
				+ "INNER JOIN car c ON c.carID=s.carID "
				+ "INNER JOIN customer cust ON cust.customerID=s.customerID";
		return template.query(query, new RowMapper<ServiceAllInfo>(){
			public ServiceAllInfo mapRow(ResultSet rs, int row) throws SQLException{
				ServiceAllInfo s = new ServiceAllInfo();
				s.setServiceID(rs.getInt(1));
				s.setRegistrationNumber(rs.getString(2));
				s.setPrice(rs.getDouble(3));
				s.setBrand(rs.getString(4));
				s.setModel(rs.getString(5));
				s.setYear(rs.getString(6));
				s.setFirstName(rs.getString(7));
				s.setSecondName(rs.getString(8));
				s.setPhoneNumber(rs.getString(9));
				return s;
			}
		});
	}

}
