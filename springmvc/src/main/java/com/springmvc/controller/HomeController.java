package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String home() {
		System.out.println("this is triggered");
		return "index";
		
	}
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("About is triggered");
		return "About";
		
	}

}
