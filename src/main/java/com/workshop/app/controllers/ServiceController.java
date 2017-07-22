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
import com.workshop.app.impl.Car;
import com.workshop.app.impl.Customer;
import com.workshop.app.impl.Service;
import com.workshop.app.impl.ServiceAllInfo;

@Controller
public class ServiceController {

	@Autowired 
	private WorkshopDao dao;
	
	@RequestMapping("/addService")
	public ModelAndView showForm(Map<String, Object> map){
		List<Car> listOfCars = dao.getCars();
		map.put("listOfCars", listOfCars);
		List<Customer> listOfCustomers = dao.getAllCustomers();
		map.put("listOfCustomers", listOfCustomers);
		
		return new ModelAndView("addService", "command", new Service());
	}
	
	@RequestMapping(value = "/saveService", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("service") Service service){
		dao.saveService(service);
		return new ModelAndView("redirect:/addService");
	}
	
	@RequestMapping("/showServices")
	public ModelAndView showServices(){
		List<ServiceAllInfo> list = dao.getAllServices();
		return new ModelAndView("showServices", "list", list);
	}
	
	@RequestMapping(value ="/deleteService/{serviceID}")
	public ModelAndView deleteService(@PathVariable int serviceID){
		dao.deleteService(serviceID);
		return new ModelAndView("redirect:/showServices");
	}
	
	@RequestMapping(value ="editService/{serviceID}")
	public ModelAndView editService(@PathVariable int serviceID, Map<String, Object> map){
		
		List<Car> listOfCars = dao.getCars();
		map.put("listOfCars", listOfCars);
		List<Customer> listOfCustomers = dao.getAllCustomers();
		map.put("listOfCustomers", listOfCustomers);
		
		Service service = dao.getServiceByID(serviceID);
		return new ModelAndView("editService", "command", service);
	}
	
	@RequestMapping(value = "/editSaveService", method = RequestMethod.POST)
	public ModelAndView editSaveService(@ModelAttribute("service") Service service){
		dao.updateService(service);
		return new ModelAndView("redirect:/showServices");
	}
	
}
