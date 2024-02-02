package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping(value="/show/all/active/products")
	public ModelAndView show_productlist()
	{
		ModelAndView mv=new ModelAndView("index");
		
		mv.addObject("title","On-Cart Home Page-All Products");
		mv.addObject("categorylist", categoryDAO.categoryList());
		mv.addObject("userclickallproducts", true);
		return mv;
	}

}
