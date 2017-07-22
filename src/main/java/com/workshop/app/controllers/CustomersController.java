package com.workshop.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.WorkshopDao;
import com.workshop.app.impl.Customer;

@Controller
public class CustomersController {
	
	@Autowired
	private WorkshopDao dao;
	
	@RequestMapping("/addCustomer")
	public ModelAndView showForm(){
		return new ModelAndView("addCustomer", "command", new Customer());
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customer") Customer customer){
		dao.saveCustomer(customer);
		return new ModelAndView("redirect:/addCustomer");
	}
	
	@RequestMapping("/showCustomers")
	public ModelAndView showCustomers(){
		List<Customer> list = dao.getAllCustomers();
		return new ModelAndView("showCustomers", "list", list);
	}
	
	@RequestMapping(value = "/deleteCustomer/{customerID}")
	public ModelAndView delete(@PathVariable int customerID){
		dao.deleteCustomer(customerID);
		return new ModelAndView("redirect:/showCustomers");
	}
	
	@RequestMapping(value = "/editCustomer/{customerID}")
	public ModelAndView edit(@PathVariable int customerID){
		Customer customer =  dao.getCustomerById(customerID);
		return new ModelAndView("editCustomer", "command", customer);
	}
	
	@RequestMapping(value ="/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("customer") Customer customer){
		dao.updateCustomer(customer);
		return new ModelAndView("redirect:/showCustomers");
	}
	
}
