package com.niit.MyOnlineFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.model.Product;

@RequestMapping(value="/json")
@Controller
public class JsonController
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/show/all/active/products")
	@ResponseBody
	public List<Product> all_active_products()
	{
		 
		return productDAO.listActiveProduct();
	}
	
	@RequestMapping(value="/show/all/active/category/{id}/products")
	@ResponseBody
	public List<Product> product_list_bycategory(@PathVariable int id)
	{
		 
		return productDAO.listActiveProductByCategory(id);
	}
	
	@RequestMapping(value="/show/all/products")
	@ResponseBody
	public List<Product> all_products()
	{
		 
		return productDAO.listProduct();
	}


}
