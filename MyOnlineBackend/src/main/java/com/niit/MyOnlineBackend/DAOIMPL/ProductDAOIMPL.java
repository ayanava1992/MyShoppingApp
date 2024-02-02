package com.niit.MyOnlineBackend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insert(Product product) 
	{
		try
		{
			product.setActive(true);
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(product);
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProduct(int p_id) 
	{
		try {
			return sessionFactory.getCurrentSession().get(Product.class,p_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Product> listProduct() 
	{
		String selectActiveCategory="FROM Product";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProduct() 
	{
		String selectActiveCategory="FROM Product WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int category_id) 
	{
		String selectActiveCategory="FROM Product WHERE active=:active and category_id=:categoryid";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		query.setParameter("categoryid", category_id);
		return query.getResultList();
	}

}
