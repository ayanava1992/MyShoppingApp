package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/show/all/active/products")
	public ModelAndView show_productlist()
	{
		ModelAndView mv=new ModelAndView("index");
		
		mv.addObject("title","On-Cart Home Page-ALL PRODUCTS");
		mv.addObject("categorylist", categoryDAO.categoryList());
		mv.addObject("productlist", productDAO.listActiveProduct());
		mv.addObject("userclickallproducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/all/active/category/{id}/products")
	public ModelAndView show_productlist(@PathVariable int id)
	{
		ModelAndView mv=new ModelAndView("index");
		
		mv.addObject("title","On-Cart Home Page-ALL PRODUCTS");
		mv.addObject("categorylist", categoryDAO.categoryList());
		mv.addObject("category", categoryDAO.getCategory(id));
		mv.addObject("productlist", productDAO.listActiveProductByCategory(id));
		mv.addObject("userclickcategoryproducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/single/{id}/product")
	public ModelAndView show_single_prod(@PathVariable int id)
	{
		ModelAndView mv=new ModelAndView("index");
		
		mv.addObject("title","On-Cart Home Page-SINGLE PRODUCT");
		mv.addObject("product", productDAO.getProduct(id));
		mv.addObject("userclicksingleproduct", true);
		return mv;
	}
	

}
