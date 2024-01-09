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
		return "home.jsp";
	}
	/*
	 * pom.xml Dependency needed tomcat-jasper 
	 * Version must thesame with tomcat-embeded-core-xx-x-xx.jar from your maven dependencies
	 * Watch //https://www.youtube.com/watch?v=nLbvzF1-vXY&list=PLsyeobzWxl7oA8QOlMtQsRT_I7Rx2hoX4&index=7
	 *Time: 10:08	
	 **/
	
}
