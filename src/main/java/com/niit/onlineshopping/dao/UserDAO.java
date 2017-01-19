package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.OSUser;

public interface UserDAO {
	public List<OSUser> list();
	
	public OSUser get(int id);
	
	public OSUser validate(String username, String password);
	
	public boolean save(OSUser osuser);
	
	public boolean update(OSUser osuser);
	
	public OSUser get(String username);


}
