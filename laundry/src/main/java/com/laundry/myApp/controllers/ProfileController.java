package com.laundry.myApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laundry.myApp.dao.CustomerDao;
import com.laundry.myApp.models.Customer;

@Controller
public class ProfileController {
	
	@Autowired
	private CustomerDao customerrepository;
	
	@GetMapping("/viewProfile")
	public ModelAndView EditProfile(Customer customer) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("profile");
		mv.addObject("customer", new Customer());
		return mv;
	}
	
	@PostMapping("EditProfile")
	public ModelAndView newProfile(Customer customer) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/customer-added");
		customerrepository.save(customer);
		return mv;
		
			}
	@GetMapping("customer-added")
	public ModelAndView customerInfo() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("listCustomer");
		mv.addObject("customList",customerrepository.findAll());
		return mv;
	}
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("alterar");
		@SuppressWarnings("deprecation")
		Customer customer=customerrepository.getOne(id);
		return mv.addObject("customer", customer);
		
		
	}
	

}
