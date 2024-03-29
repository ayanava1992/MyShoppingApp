package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;

@Controller
public class FrontController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	
	public ModelAndView home() 
	{
		ModelAndView mv= new ModelAndView("index");
		
		mv.addObject("title","On-Cart Home Page");
		mv.addObject("categorylist", categoryDAO.categoryList());
		mv.addObject("userclickhome", true);
		return mv;
	}

}
