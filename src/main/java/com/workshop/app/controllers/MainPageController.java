package com.workshop.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

	@RequestMapping("/mainPage")
	public ModelAndView back(){
		return new ModelAndView("loginpage");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(){
		return new ModelAndView("logoutIndex");
	}
	
}
