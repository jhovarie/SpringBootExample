package com.telusko.MyWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	//http://localhost:8080/home?aid=1&aname=joy&lang=java
	@RequestMapping("home") //set the url location
	public ModelAndView home(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",alien);
		mv.setViewName("home");
		return mv;
	}
	
	/*
	//http://localhost:8080/home?name=barik
	@RequestMapping("home") //set the url location
	public ModelAndView home(@RequestParam("name")String myName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		return mv;
	}*/
	
	/*
	@RequestMapping("home") //set the url location
	public String home(@RequestParam("name")String myName, HttpSession session) {
		session.setAttribute("name", myName);
		return "home";
	}
	*/
		
	/*
	//http://localhost:8080/home?name=barik
	@RequestMapping("home") //set the url location
	public String home(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("hi "+name);
		session.setAttribute("name", name);
		return "home";
	}
	*/
	
}
