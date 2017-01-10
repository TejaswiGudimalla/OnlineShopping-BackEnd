package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Product;

public interface ProductDAO {
	
    public List<Product> list();
	
    public boolean save(Product product);
	
	public boolean update(Product product);
}
