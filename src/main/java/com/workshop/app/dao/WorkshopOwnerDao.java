package com.workshop.app.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.workshop.app.api.Dao;
import com.workshop.app.api.DataFromJdbc;
import com.workshop.app.impl.WorkshopOwner;

public class WorkshopOwnerDao implements Dao{
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	} // end of method

	@Override
	public int save(DataFromJdbc data) {
		return 0;
	} // end of method

	@Override
	public int update(DataFromJdbc data) {
		return 0;
	}// end of method

	@Override
	public int delete(int id) {
		return 0;
	} // end of method

	@Override
	public int getById(int id) {
		return 0;
	} 

	@Override
	public List<DataFromJdbc> getData() {
		return null;
	} // end of method
	
	public int getIDByUsername(WorkshopOwner workshopOwner){
		String query = "SELECT workshopOwnerID FROM WorkshopOwner WHERE username='" + workshopOwner.getUsername() + "'";
		workshopOwner.setWorkshopOwnerID(template.queryForObject(query, Integer.class));
		return workshopOwner.getWorkshopOwnerID();
	} // end of method
	
	public String getPasswordById(int id){
		String query = "SELECT password FROM WorkshopOwner WHERE workshopOwnerID=" + id + "";
		return template.queryForObject(query, String.class);
	} // end of method
	
	public String loginCondition(WorkshopOwner workshopOwner){
		workshopOwner.setPassword(getPasswordById(getIDByUsername(workshopOwner)));
		return workshopOwner.getPassword();
	} // end of method
	
}
