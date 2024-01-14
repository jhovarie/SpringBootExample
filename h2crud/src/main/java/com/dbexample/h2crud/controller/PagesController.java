package com.dbexample.h2crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbexample.h2crud.service.ProductService;

@Controller
public class PagesController {
	
	@Autowired
    private ProductService productService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/addition1")
    public ModelAndView addition1() {
        return new ModelAndView("addition1");
    }

    @PostMapping("/addition1")
    public ModelAndView performAddition(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2) {
        int result = num1 + num2;
        ModelAndView modelAndView = new ModelAndView("addition2");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @GetMapping("/addition2")
    public ModelAndView addition2() {
        return new ModelAndView("addition2");
    }
    
    @GetMapping("/productmanagement")
    public String showProductManagement() {
        return "productmanagement"; // Assuming "dashboard.jsp" is your view
    }
    
    @GetMapping("/searchdatapage")
    public ModelAndView searchDataPage() {
        ModelAndView modelAndView = new ModelAndView("searchdatapage");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }
    
}
