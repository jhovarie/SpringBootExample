package com.telusko.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	//http://localhost:8080/home
	@RequestMapping("home") //set the url location
	public String home(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("hi "+name);
		session.setAttribute("name", name);
		return "home";
	}
	
}
