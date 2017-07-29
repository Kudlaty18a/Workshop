package com.workshop.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.WorkshopDao;
import com.workshop.app.impl.ActionHistory;
import com.workshop.app.impl.Car;
import com.workshop.app.impl.Customer;
import com.workshop.app.impl.Service;

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
	
	@RequestMapping("/showActions/{serviceID}")
	public ModelAndView showActions(@PathVariable int serviceID, Map<String, Object> map){
		List<ActionHistory> listOfActions = dao.getAllActionHistoriesByServiceID(serviceID);
		Service service = dao.getServiceByID(serviceID);
		map.put("service", service);
		Car car = dao.getCarByID(service.getCarID());
		map.put("car", car);
		Customer customer = dao.getCustomerById(service.getCustomerID());
		map.put("customer", customer);
		
		double sumOfActionPrices = 0;
		double result;
		
		for(ActionHistory actionHistory : listOfActions){
			sumOfActionPrices += actionHistory.getPrice();
		}
		
		result = (double) (service.getPrice() - sumOfActionPrices);
		map.put("result", result);
		
		return new ModelAndView("showActions", "listOfActions", listOfActions);
	}
	
	@RequestMapping(value = "/deleteAction/{actionHistoryID}")
	public ModelAndView delete(@PathVariable int actionHistoryID){
		dao.deleteActionHistory(actionHistoryID);
		return new ModelAndView("redirect:/showServices");
	}
	
	@RequestMapping(value = "/editAction/{actionHistoryID}")
	public ModelAndView edit(@PathVariable int actionHistoryID){
		ActionHistory actionHistory = dao.getActionHistoryByID(actionHistoryID);
		return new ModelAndView("editAction", "command", actionHistory);
	}
	
	@RequestMapping(value = "/editSaveAction", method = RequestMethod.POST)
	public ModelAndView editSaveCar(@ModelAttribute("actionHistory") ActionHistory actionHistory){
		dao.updateActionHistory(actionHistory);
		return new ModelAndView("redirect:/showServices");
	}
	
}
