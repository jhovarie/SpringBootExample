package com.telusko.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	//http://localhost:8080/home
	@RequestMapping("home") //set the url location
	public String home() {
		System.out.println("hi");
		return "home";
	}
	
}
