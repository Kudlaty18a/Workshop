package com.workshop.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.workshop.app.impl.Car;

public class CarDao {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Car car) {
		String query = "INSERT INTO car(brand, model, year) VALUES('" + car.getBrand() + "', '" 
				+ car.getModel() + "', '" + car.getYear() + "')";
		return template.update(query);
	}
	
	public int update(Car car){
		String query = "UPDATE car SET brand='" + car.getBrand() + "', model='" 
				+ car.getModel() + "', year='" + car.getYear() + "' WHERE carID=" + car.getCarID();
		return template.update(query);
	}
	
	public int delete(int id){
		String query = "DELETE FROM car WHERE carID=" + id + "";
		return template.update(query);
	}
	
	public Car getCarByID(int id){
		String query = "SELECT * FROM car WHERE carID=" + id + "";
		return template.queryForObject(query, new BeanPropertyRowMapper<Car>(Car.class));
	}
	
	public List<Car> getCars(){
		String query = "SELECT * FROM car";
		return template.query(query, new RowMapper<Car>(){
			public Car mapRow(ResultSet rs, int row) throws SQLException{
				Car car = new Car();
				car.setCarID(rs.getInt(1));
				car.setBrand(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setYear(rs.getString(4));
				return car;
			}
		});
	}

}
