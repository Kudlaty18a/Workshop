package com.workshop.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.WorkshopDao;
import com.workshop.app.impl.ActionHistory;

@Controller
public class ActionHistoryController {
	
	@Autowired
	private WorkshopDao dao;
	private int serviceID;
	
	@RequestMapping("/addAction/{serviceID}")
	public ModelAndView showForm(@PathVariable int serviceID){
		this.serviceID = serviceID;
		return new ModelAndView("addAction", "command", new ActionHistory());
	}
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("actionHistory") ActionHistory actionHistory){
		actionHistory.setServiceID(serviceID);
		dao.saveAction(actionHistory);
		return new ModelAndView("redirect:/showServices");
	}
	
}
