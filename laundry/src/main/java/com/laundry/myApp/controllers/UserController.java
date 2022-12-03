package com.laundry.myApp.controllers;

import javax.validation.Valid;

import com.laundry.myApp.controllers.dto.UserProfileDto;
import com.laundry.myApp.controllers.form.RegistrationFormDto;
import com.laundry.myApp.services.UserService;
import lombok.AllArgsConstructor;
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

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView login() {

		List<UserProfileDto> users = userService
				.getAll()
				.stream()
				.map(UserProfileDto::new)
				.toList();

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
	public String register(@Valid RegistrationFormDto registrationForm, BindingResult result,
						   Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/index";
		}
		
		User user = userService.getByUsername(registrationForm.getUsername());

			
		
	}

		
	

		
	

}
