package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.User;

public class UserTest
{
	private User u;
	private static UserDAO userDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void insertUsertest()
	{
		u=new User();
		u.setFirstName("Bishal");
		u.setLastName("Bagchi");
		u.setPhone("9802135467");
		u.setEmail("bb1@gmail.com");
		u.setPassword("user@123");
		u.setRole("User");
		u.setEnabled(true);
		
		assertEquals("Error adding user",true,userDAO.insert(u));
	}
	
	//@Test
	public void getuserbyemailtest()
	{
		u=userDAO.getUserByEmail("ad@gmail.com");
		assertEquals("Error getting user","	8907654321",u.getPhone());
	}
}
