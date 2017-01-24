package com.niit.onlineshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshopping.dao.UserDAO;
import com.niit.onlineshopping.model.User;

public class TestUserDAO{
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestUserDAO() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineshopping");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAOImpl");
		user = (User) context.getBean("User");
	}
	public boolean validate(String id, String password)
	{
		if (userDAO.validate(id, password)==null)
		{
			System.out.println("User does not exist");
			return false;
		}
		else
		{
			System.out.println("User exist");
			return true;
		}
	}
	public static void main(String args[])
	{
		TestUserDAO t = new TestUserDAO();
		t.validate("witty", "Tony");
	}
}
