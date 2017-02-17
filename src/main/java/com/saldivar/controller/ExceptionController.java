package com.saldivar.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception main class
 * 
 * @author Jorge.Saldivar
 *
 */
@ControllerAdvice
public class ExceptionController {
 
	@ExceptionHandler(Exception.class)
	public String exception(Exception exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "error";
	}

}
