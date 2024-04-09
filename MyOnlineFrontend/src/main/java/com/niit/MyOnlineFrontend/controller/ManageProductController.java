package com.niit.MyOnlineFrontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Category;
import com.niit.MyOnlineBackend.model.Product;
import com.niit.MyOnlineBackend.model.User;

@Controller
@RequestMapping(value = "/manage")
public class ManageProductController {
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/show")

	public ModelAndView show(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userclickmanageproduct", true);

		if (operation != null) {
			switch (operation) {
			case "product":
				mv.addObject("message", "SUCCESSFULLY GROCERY ADDED");
				break;
				
			case "productupdate":
				mv.addObject("message", "SUCCESSFULLY GROCERY UPDATED");
				break;

			case "category":
				mv.addObject("message", "SUCCESSFULLY CATEGORY ADDED");
				break;
			}
		}
		return mv;
	}

	@ModelAttribute(name = "product")
	public Product getproduct() {
		return new Product();
	}

	@ModelAttribute(name = "category")
	public Category getcategory() {
		return new Category();
	}

	@ModelAttribute(name = "categoryList")
	public List<Category> getcategorylist() {
		return categoryDAO.categoryList();
	}

	@ModelAttribute(name = "supplierList")
	public List<User> getSupplierList() {
		return userDAO.getSuppliers();
	}

	@RequestMapping(value = "/product")
	public String addproduct(@Valid @ModelAttribute("product") Product p, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("userclickmanageproduct", true);
			return "index";
		} 
		
		else {
			if(p.getId()==0)
			{
				productDAO.insert(p);
				return "redirect:/manage/show?operation=product";
			}
			
			else
			{
				productDAO.update(p);
				return "redirect:/manage/show?operation=productupdate";
			}
			
		}

	}

	@RequestMapping(value = "/add/category")
	public String addcateggory(@ModelAttribute("category") Category c) {
		c.setActive(true);
		categoryDAO.insert(c);
		return "redirect:/manage/show?operation=category";

	}

	@RequestMapping(value = "/edit/{id}/product")
	public ModelAndView editproduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userclickmanageproduct", true);
		mv.addObject("product", productDAO.getProduct(id));
		return mv;

	}
	
	@RequestMapping(value = "/product/{id}/activation")
	public String product_activateDeactivate(@PathVariable("id") int id) 
	{
		Product p=productDAO.getProduct(id);
		
		p.setActive(!p.isActive());
		
		productDAO.update(p);
		
		return(p.isActive()?
				"SUCCESSFULLY ACTIVATED THE GROCERY PRODUCT WITH ID: "+p.getId()
				: "SUCCESSFULLY DEACTIVATED THE GROCERY PRODUCT WITH ID: "+p.getId());
	}

}
