package com.niit.onlineshopping;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshopping.dao.UserDAO;
import com.niit.onlineshopping.model.OSUser;

public class UserDAOTestCase {
	
	@Autowired
	 static  UserDAO userDAO;
	
	@Autowired
	 static OSUser osuser;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineshopping");
		context.refresh();
		
		osuser=(OSUser)context.getBean("OSUser");
		userDAO=(UserDAO)context.getBean("userDAOImpl");
		
	}
	
	@Test
	 public void getUserTestCase()
	 {
	osuser=	userDAO.get("wit");
		Assert.assertEquals("User Test Case","wit",osuser.getName());
	 }
	
	@Test
	public void validateCredentials()
	{
		osuser=userDAO.validate("wit","Tony");
		Assert.assertEquals("Validate Test Case",osuser,osuser);
	}
   
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",1, 1);
	}
}
