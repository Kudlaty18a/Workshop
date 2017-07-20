package com.workshop.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.CarDao;
import com.workshop.app.dao.CustomerDao;
import com.workshop.app.dao.ServiceDao;
import com.workshop.app.impl.Car;
import com.workshop.app.impl.Customer;
import com.workshop.app.impl.Service;
import com.workshop.app.impl.ServiceAllInfo;

@Controller
public class ServiceController {

	@Autowired
	private ServiceDao serviceDao;
	@Autowired 
	private CarDao carDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	
	@RequestMapping("/addService")
	public ModelAndView showForm(Map<String, Object> map){
		List<Car> listOfCars = carDao.getCars();
		map.put("listOfCars", listOfCars);
		List<Customer> listOfCustomers = customerDao.getAllCustomers();
		map.put("listOfCustomers", listOfCustomers);
		
		return new ModelAndView("addService", "command", new Service());
	}
	
	@RequestMapping(value = "/saveService", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("service") Service service){
		serviceDao.save(service);
		return new ModelAndView("redirect:/addService");
	}
	
	@RequestMapping("/showServices")
	public ModelAndView showServices(){
		List<ServiceAllInfo> list = serviceDao.getAllServices();
		return new ModelAndView("showServices", "list", list);
	}
	
}
