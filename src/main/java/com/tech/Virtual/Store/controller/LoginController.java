package com.tech.Virtual.Store.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {
	
	@PostMapping("/login")
	public ModelAndView Login() {
		ModelAndView mv =  new ModelAndView("/login");
		return mv;
	}	

}

