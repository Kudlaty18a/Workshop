package com.workshop.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.WorkshopDao;
import com.workshop.app.impl.WorkshopOwner;

@Controller
public class WorkshopController {
	
	@Autowired
	private WorkshopDao dao;
	@Autowired
	private WorkshopOwner workshopOwner;

	@RequestMapping("/login")
	public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response){
		workshopOwner.setUsername(request.getParameter("username"));
		String password = request.getParameter("password");
		
		if(password.equals(dao.loginCondition(workshopOwner))){
			return new ModelAndView("loginpage");
		}
		else{
			return new ModelAndView("errorpage");
		}
		
	} // end of method
	
}
