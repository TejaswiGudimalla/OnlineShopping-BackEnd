package com.niit.onlineshopping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.onlineshopping.model.User;

@Repository
public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	public User validate(int id, String password);
	
	public boolean saveorupdate(User user);
	
	public boolean delete(User user);
	
	public User get(String username);


}
