package com.jorgesaldivar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Home page main controller
 *
 * @author Jorge.Saldivar
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "index"})
    public String home() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Principal principal) {
        return principal != null ? "redirect:/" : "login";
    }

}
