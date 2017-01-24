package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	public User validate(String username, String password);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public User get(String username);


}
