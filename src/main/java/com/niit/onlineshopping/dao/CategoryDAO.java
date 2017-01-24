package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Category;

public interface CategoryDAO {
	
    public List<Category> list();
    
    public Category get(int id);
    
    //public Category getByName(String name);
		
    public boolean save(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(Category category);

}
