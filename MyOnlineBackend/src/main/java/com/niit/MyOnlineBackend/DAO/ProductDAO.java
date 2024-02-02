package com.niit.MyOnlineBackend.DAO;

import java.util.List;

import com.niit.MyOnlineBackend.model.Product;

public interface ProductDAO 
{
	public boolean insert(Product product);
	public boolean update(Product product);
	public Product getProduct(int p_id);
	public List<Product> listProduct();
	public List<Product> listActiveProduct();
	public List<Product> listActiveProductByCategory(int category_id);
}
