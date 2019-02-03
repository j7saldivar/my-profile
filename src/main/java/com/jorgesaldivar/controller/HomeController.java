package com.jorgesaldivar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Home page main controller
 *
 * @author Jorge.Saldivar
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "index"})
    public String home(Model model) {
        model.addAttribute(
                "yearsOfExperience",
                Period.between(LocalDate.of(2013, Month.JUNE, 1), LocalDate.now()).getYears());
        return "index";
    }

    @RequestMapping("/login")
    public String login(Principal principal) {
        return principal != null ? "redirect:/" : "login";
    }

}
