package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Category;
import com.niit.MyOnlineBackend.model.Product;
import com.niit.MyOnlineBackend.model.User;

public class ProductTest 
{
	private Category c;
	private User u;
	private Product p;
	private static CategoryDAO categoryDAO;
	private static UserDAO userDAO;
	private static ProductDAO productDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		userDAO=(UserDAO) context.getBean("userDAO");
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void productInsertTest()
	{
		p= new Product();
		
		
		/*p.setName("Ensure Nutrition Drink");
		p.setDescription("ENSURE Diabetes Care Nutrition Drink");
		p.setBrand("Ensure");
		c= categoryDAO.getCategory(3);
		p.setCategory_id(c.getId());
		p.setSupplier_id(38);
		p.setQuantity(6);
		p.setUnit_price(786);
		*/
		
		/*p.setName("India Gate Basmati Rice ");
		p.setDescription("INDIA GATE Select Basmati Rice (Basmati chal) (Long Grain)");
		p.setBrand("India Gate");
		c= categoryDAO.getCategory(4);
		p.setCategory_id(c.getId());
		p.setSupplier_id(38);
		p.setQuantity(3);
		p.setUnit_price(823);
		*/
		
		p.setName("Nestle Nan Pro");
		p.setDescription("Nestle Nan Pro Infant Formula with Probiotic, Stage 1");
		p.setBrand("Nestle");
		c= categoryDAO.getCategory(5);
		p.setCategory_id(c.getId());
		p.setSupplier_id(38);
		p.setQuantity(4);
		p.setUnit_price(805);
		
		
		
		
		assertEquals("Error adding Product", true, productDAO.insert(p));
		
		
	}

}
