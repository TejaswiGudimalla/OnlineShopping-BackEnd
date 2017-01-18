package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Product;

public interface ProductDAO {
	
    public List<Product> list();
    
    public Product get(int id);
	
    public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
	
}
