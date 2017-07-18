package com.workshop.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.app.dao.CarDao;
import com.workshop.app.impl.Car;

@Controller
public class CarsController {

	@Autowired
	private CarDao carDao;

	@RequestMapping("/addCar")
	public ModelAndView showForm() {
		return new ModelAndView("addCar", "command", new Car());
	}
	
	@RequestMapping(value = "/saveCar", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("car") Car car){
		carDao.save(car);
		return new ModelAndView("redirect:/addCar");
	}

}
