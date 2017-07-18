package com.workshop.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.workshop.app.impl.Customer;

public class CustomerDao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Customer customer) {
		String query = "INSERT INTO customer(firstName, secondName, phoneNumber) VALUES('" + customer.getFirstName()
				+ "', '" + customer.getSecondName() + "', '" + customer.getPhoneNumber() + "')";
		return template.update(query);
	}

	public int update(Customer customer) {
		String query = "UPDATE customer SET firstName='" + customer.getFirstName() 
			+ "', secondName='" + customer.getSecondName() + "', phoneNumber='" 
			+ customer.getPhoneNumber() + "' WHERE customerID=" + customer.getCustomerID();
		return template.update(query);

	}

	public int delete(int id) {
		String query = "DELETE FROM customer WHERE customerID=" + id + "";
		return template.update(query);

	}

	public Customer getCustomerById(int id) {
		String query = "SELECT customerID, firstName, secondName, phoneNumber FROM customer WHERE customerID=" + id + "";
		return template.queryForObject(query, new BeanPropertyRowMapper<Customer>(Customer.class));

	}

	public List<Customer> getAllCustomers() {
		
		return template.query("SELECT * FROM customer", new RowMapper<Customer>(){
			public Customer mapRow(ResultSet rs, int row) throws SQLException{
				Customer customer = new Customer();
				customer.setCustomerID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setSecondName(rs.getString(3));
				customer.setPhoneNumber(rs.getString(4));
				return customer;
			}
		});

	}

}
