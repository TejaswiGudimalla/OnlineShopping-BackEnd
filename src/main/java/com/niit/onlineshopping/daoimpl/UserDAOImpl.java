package com.niit.onlineshopping.daoimpl;

import com.niit.onlineshopping.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	public boolean isValidCredentials(String Username, String Password) {
		if(Username.equals("niit") && Password.equals("niit123"))
		{
			return true;
		}
		else
		{
		// TODO Auto-generated method stub
		return false;

		}
	}
	
}
