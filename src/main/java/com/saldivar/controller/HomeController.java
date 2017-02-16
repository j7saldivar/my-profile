package com.saldivar.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({ "/", "index" })
	public String getHome() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Principal principal) {
		return (principal != null) ? "redirect:/" : "login";
	}

}
