package com.niit.MyOnlineBackend.DAOIMPL;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Address;
import com.niit.MyOnlineBackend.model.User;



@Transactional
@Repository("userDAO")
public class UserDAOIMPL implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insert(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean insertAddress(Address address) 
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByEmail(String email) 
	{
		try
		{
			String selectActiveCategory="FROM User WHERE email=:email";
			
			Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
			
			query.setParameter("email",email);
			
			return (User) query.getSingleResult();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return  null;
		}
	}
	
	@Override
	public List<User> getSuppliers() 
	{
		try
		{
			String selectActiveCategory="FROM User WHERE role=:role";
			
			Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
			
			query.setParameter("role","Supplier");
			
			return query.getResultList();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return  null;
		}
	}


}
