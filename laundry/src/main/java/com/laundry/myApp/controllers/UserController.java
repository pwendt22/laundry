package com.laundry.myApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.laundry.myApp.dao.UserDao;
import com.laundry.myApp.models.User;


@Controller
public class UserController {
	
	@Autowired
	private UserDao customerrepository;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
		
	}
	
	@GetMapping("/registration")
	public ModelAndView register() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("registration");
		return mv;
		
	}
	@PostMapping("saveUser")
	public ModelAndView register(User user) {
		ModelAndView mv=new ModelAndView();
		customerrepository.save(user);
		mv.setViewName("redirect:/viewProfile");
		return mv;
		
	}

		
	

}
