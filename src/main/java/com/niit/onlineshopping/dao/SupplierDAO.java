package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Supplier;

public interface SupplierDAO {
	
    public List<Supplier> list();
    
    public Supplier get(int id);
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);

}
