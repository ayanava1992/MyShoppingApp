package com.niit.MyOnlineFrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Address;
import com.niit.MyOnlineBackend.model.User;
import com.niit.MyOnlineFrontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	@Autowired
	UserDAO userDAO;
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void add_user(User user, RegisterModel r_m) 
	{
		r_m.setUser(user); 
	}
	
	public void add_billing(Address billing, RegisterModel r_m) 
	{
		r_m.setBilling(billing); 
	}
	

	public String validate(User user , MessageContext error)
	{
		if((user.getConfirm_password() == null || user.getConfirm_password().contentEquals("")))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("CONFIRM PASSWORD CAN'T BE EMPTY!!")
					.build());
			return "error";
		}
		
		if(userDAO.getUserByEmail(user.getEmail()) != null)
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("ENTERED EMAIL IS ALREADY TAKEN!")
					.build());
			return "error";
	    }
		
		if((user.getPassword().equals(user.getConfirm_password())))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("ENTERED PASSWORD DOES NOT MATCHING CONFIRM PASSWORD!!")
					.build());
			return "error";
		}
		return "billing";
	}
	
	public String saveAll(RegisterModel r_m)
	{
		User user=r_m.getUser();
		user.setEnabled(true);
		userDAO.insert(user);
		
		Address billing=r_m.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		userDAO.insertAddress(billing);
		return "success";
	}
}
