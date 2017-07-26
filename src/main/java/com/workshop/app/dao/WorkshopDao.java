package com.workshop.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.workshop.app.impl.ActionHistory;
import com.workshop.app.impl.Car;
import com.workshop.app.impl.Customer;
import com.workshop.app.impl.Service;
import com.workshop.app.impl.ServiceAllInfo;
import com.workshop.app.impl.WorkshopOwner;

public class WorkshopDao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	} // end of method

	/*
	 * Login conditions
	 */

	public int getIDByUsername(WorkshopOwner workshopOwner) {
		String query = "SELECT workshopOwnerID FROM WorkshopOwner WHERE username='" + workshopOwner.getUsername() + "'";
		workshopOwner.setWorkshopOwnerID(template.queryForObject(query, Integer.class));
		return workshopOwner.getWorkshopOwnerID();
	} // end of method

	public String getPasswordById(int id) {
		String query = "SELECT password FROM WorkshopOwner WHERE workshopOwnerID=" + id + "";
		return template.queryForObject(query, String.class);
	} // end of method

	public String loginCondition(WorkshopOwner workshopOwner) {
		workshopOwner.setPassword(getPasswordById(getIDByUsername(workshopOwner)));
		return workshopOwner.getPassword();
	} // end of method

	/*
	 * Dao for car table
	 */

	public int saveCar(Car car) {
		String query = "INSERT INTO car(brand, model, year) VALUES('" + car.getBrand() + "', '" + car.getModel()
				+ "', '" + car.getYear() + "')";
		return template.update(query);
	} // end of method

	public int updateCar(Car car) {
		String query = "UPDATE car SET brand='" + car.getBrand() + "', model='" + car.getModel() + "', year='"
				+ car.getYear() + "' WHERE carID=" + car.getCarID();
		return template.update(query);
	} // end of method

	public int deleteCar(int id) {
		
		deleteServiceByCarID(id);
		
		String query = "DELETE FROM car WHERE carID=" + id + "";
		return template.update(query);
	} // end of method

	public Car getCarByID(int id) {
		String query = "SELECT * FROM car WHERE carID=" + id + "";
		return template.queryForObject(query, new BeanPropertyRowMapper<Car>(Car.class));
	} // end of method

	public List<Car> getCars() {
		String query = "SELECT * FROM car";
		return template.query(query, new RowMapper<Car>() {
			public Car mapRow(ResultSet rs, int row) throws SQLException {
				Car car = new Car();
				car.setCarID(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYear(rs.getString(4));
				return car;
			}
		});
	} // end of method

	/*
	 * Dao for customer table
	 */

	public int saveCustomer(Customer customer) {
		String query = "INSERT INTO customer(firstName, secondName, phoneNumber) VALUES('" + customer.getFirstName()
				+ "', '" + customer.getSecondName() + "', '" + customer.getPhoneNumber() + "')";
		return template.update(query);
	} // end of method

	public int updateCustomer(Customer customer) {
		String query = "UPDATE customer SET firstName='" + customer.getFirstName() + "', secondName='"
				+ customer.getSecondName() + "', phoneNumber='" + customer.getPhoneNumber() + "' WHERE customerID="
				+ customer.getCustomerID();
		return template.update(query);

	} // end of method

	public int deleteCustomer(int id) {
		
		deleteServiceByCustomerID(id);
		
		String query = "DELETE FROM customer WHERE customerID=" + id + "";
		return template.update(query);

	} // end of method

	public Customer getCustomerById(int id) {
		String query = "SELECT customerID, firstName, secondName, phoneNumber FROM customer WHERE customerID=" + id
				+ "";
		return template.queryForObject(query, new BeanPropertyRowMapper<Customer>(Customer.class));

	} // end of method

	public List<Customer> getAllCustomers() {

		return template.query("SELECT * FROM customer", new RowMapper<Customer>() {
			public Customer mapRow(ResultSet rs, int row) throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setSecondName(rs.getString(3));
				customer.setPhoneNumber(rs.getString(4));
				return customer;
			}
		});

	} // end of method

	/* 
	 * Dao for service table
	 */

	public int saveService(Service service) {
		String query = "INSERT INTO service(registrationNumber, price, carID, customerID) VALUES('"
				+ service.getRegistrationNumber() + "', " + service.getPrice() + ", " + service.getCarID() + ", "
				+ service.getCustomerID() + ")";
		return template.update(query);
	} // end of method
	
	public int deleteService(int id) {
		String query = "DELETE FROM service WHERE serviceID=" + id + "";
		return template.update(query);

	} // end of method
	
	public int deleteServiceByCarID(int carID){
		String query = "DELETE FROM service WHERE carID=" + carID;
		return template.update(query);
	} // end of method
	
	public int deleteServiceByCustomerID(int customerID){
		String query = "DELETE FROM service WHERE customerID=" + customerID;
		return template.update(query);
	} // end of method
	
	public Service getServiceByID(int id) {
		String query = "SELECT serviceID, registrationNumber, price, carID, customerID FROM service WHERE serviceID=" + id
				+ "";
		return template.queryForObject(query, new BeanPropertyRowMapper<Service>(Service.class));

	} // end of method
	
	public int updateService(Service service) {
		String query = "UPDATE service SET registrationNumber='" + service.getRegistrationNumber()
			+ "', price=" + service.getPrice() + ", carID=" + service.getCarID()
			+ ", customerID=" + service.getCustomerID() + " WHERE serviceID=" + service.getServiceID();
		return template.update(query);

	} // end of method

	public List<ServiceAllInfo> getAllServices() {
		String query = "SELECT s.serviceID, s.registrationNumber, s.price, c.brand, c.model, c.year, "
				+ "cust.firstName, cust.secondName, cust.phoneNumber " + "FROM service s "
				+ "INNER JOIN car c ON c.carID=s.carID " + "INNER JOIN customer cust ON cust.customerID=s.customerID";
		return template.query(query, new RowMapper<ServiceAllInfo>() {
			public ServiceAllInfo mapRow(ResultSet rs, int row) throws SQLException {
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
	} // end of method
	
	/*
	 * ActionHistory Dao
	 */
	
	public int saveAction(ActionHistory history){
		String query = "INSERT INTO actionhistory(actionDate, operation, price, serviceID) VALUES(CURRENT_DATE(), '" 
				+ history.getOperation() + "', " + history.getPrice() + ", " + history.getServiceID() + ")";
		return template.update(query);
	} // end of method

}
