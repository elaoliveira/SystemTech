package com.tech.Virtual.Store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

	@GetMapping("/workspace")
	public String acessarPrincipal() {
		return "workspace/home";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
}
