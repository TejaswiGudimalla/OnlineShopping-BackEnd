package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Category;

public interface CategoryDAO {
	
public List<Category> list();
		
    public boolean save(Category category);
	
	public boolean update(Category category);

}
