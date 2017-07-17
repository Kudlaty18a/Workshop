package com.workshop.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.WorkshopOwnerDao;
import com.workshop.app.impl.WorkshopOwner;

@Controller
public class WorkshopController {
	
	@Autowired
	private WorkshopOwnerDao workshopOwnerDao;
	@Autowired
	private WorkshopOwner workshopOwner;
	HttpSession session;

	@RequestMapping("/login")
	public ModelAndView welcomePage(HttpServletRequest request, HttpServletResponse response){
		workshopOwner.setUsername(request.getParameter("username"));
		String password = request.getParameter("password");
		
		if(password.equals(workshopOwnerDao.loginCondition(workshopOwner))){
			session = request.getSession(true);
			return new ModelAndView("loginpage");
		}
		else{
			return new ModelAndView("errorpage");
		}
		
	} // end of method
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		session = request.getSession(false);
		return new ModelAndView("index");
	}
	
}
