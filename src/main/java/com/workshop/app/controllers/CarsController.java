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
import com.workshop.app.impl.Car;

@Controller
public class CarsController {

	@Autowired
	private WorkshopDao dao;

	@RequestMapping("/addCar")
	public ModelAndView showForm() {
		return new ModelAndView("addCar", "command", new Car());
	}
	
	@RequestMapping(value = "/saveCar", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("car") Car car){
		dao.saveCar(car);
		return new ModelAndView("redirect:/addCar");
	}
	
	@RequestMapping("/showCars")
	public ModelAndView showCars(){
		List<Car> list = dao.getCars();
		return new ModelAndView("showCars", "list", list);
	}
	
	@RequestMapping(value = "/deleteCar/{carID}")
	public ModelAndView delete(@PathVariable int carID){
		dao.deleteCar(carID);
		return new ModelAndView("redirect:/showCars");
	}
	
	@RequestMapping(value = "/editCar/{carID}")
	public ModelAndView editCar(@PathVariable int carID){
		Car car = dao.getCarByID(carID);
		return new ModelAndView("editCar", "command", car);
	}
	
	@RequestMapping(value = "/editSaveCar", method = RequestMethod.POST)
	public ModelAndView editSaveCar(@ModelAttribute("car") Car car){
		dao.updateCar(car);
		return new ModelAndView("redirect:/showCars");
	}

}
