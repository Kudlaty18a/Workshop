package com.workshop.app.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.workshop.app.impl.WorkshopOwner;

public class WorkshopOwnerDao {
	
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
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
