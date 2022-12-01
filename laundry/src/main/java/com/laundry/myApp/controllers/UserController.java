package com.laundry.myApp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laundry.myApp.dao.UserDao;
import com.laundry.myApp.models.User;
import com.laundry.myApp.repository.UsuarioRepository;


@Controller
public class UserController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
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
	@PostMapping("/saveUser")
	public String register(@Valid User user, BindingResult result, 
				Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/index";
		}
		
		User usr = UsuarioRepository.findByLogin(user.getLogin());
		if (usr != null) {
			mod

			
		
	}

		
	

		
	

}
