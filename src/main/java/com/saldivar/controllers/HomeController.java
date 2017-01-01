package com.saldivar.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saldivar.dao.UserRepository;
import com.saldivar.domains.Product;
import com.saldivar.domains.User;

@Controller
public class HomeController {

	@Autowired
	private UserRepository ur;
	
	@RequestMapping({ "/", "index" })
	public String getHome() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Principal principal) {
		return (principal != null) ? "redirect:/" : "login";
	}

	@RequestMapping("/home")
	public String getHomepage() {
		return "home";
	}

	@RequestMapping({ "/product-repository", "product-repository/{user}" })
	@ResponseBody
	public User getProduct(@PathVariable Optional<String> user) {
		if (user.isPresent()) {
			User userAccount = new User();
			userAccount.setUsername(user.get());
	
			Product product = new Product();
			product.setName("Mango");
			
			userAccount.getProduct().add(product);
			
			ur.save(userAccount);
		}
		return ur.findByUsername("Samantha");
	}

}
