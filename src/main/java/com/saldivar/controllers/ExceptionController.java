package com.saldivar.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public String exception(Exception exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "error";
	}

}
