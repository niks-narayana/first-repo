package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

	 @GetMapping("/")
	  public String index(Model model, Principal principal) {
		 System.out.println("Get mapping called");
	    model.addAttribute("message", "Hello " + principal.getName());
	    return "index";
	  }
}
