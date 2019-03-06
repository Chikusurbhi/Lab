package com.cg.springmvc.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvc.bean.Customer;

@Controller
public class HomeController {
	/*
	 * @RequestMapping("homePage") public String displayHomePage(Model model) {
	 * LocalDate date=LocalDate.now(); model.addAttribute("today",date); return
	 * "Home"; }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "homePage")
	public ModelAndView displayHomePage() {
		LocalDate date = LocalDate.now();
		ModelAndView mv = new ModelAndView();
		mv.addObject("today", date);
		mv.setViewName("Home");
		// or ModelAndView mv=new ModelAndView("Home","today",date)
		return mv;
	}

	@RequestMapping("showRegistrationForm")
	public String showRegistrationForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "CustomerRegistration";
	}

	// @RequestMapping("registerUserAction")
	/*
	 * public String RegisterCustomerDetails(@RequestParam("fname")String firstName,
	 * 
	 * @RequestParam("lname")String lastName,
	 * 
	 * @RequestParam("age")int age,
	 * 
	 * @RequestParam("mobno")String mobNo,
	 * 
	 * @RequestParam("email")String email,
	 * 
	 * @RequestParam("city")String city,Model model)
	 * 
	 * 
	 * {//code to process on customer details
	 * 
	 * model.addAttribute("firstname",firstName);
	 * model.addAttribute("lastname",lastName); model.addAttribute("email",email);
	 * 
	 * return "Success";
	 */

	@RequestMapping("registerUserAction")
	public String RegisterCustomerDetails(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "CustomerRegistration";
		}
		model.addAttribute("customer", customer);
		return "Success";
	}

}
