package com.niit.onlineshopping;

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
	osuser=	userDAO.get(101);
		Assert.assertEquals("User Test Case","Tony",osuser.getName());
	 }
	
	@Test
	public void validateCredentials()
	{
		osuser=userDAO.validate("witty","Tony");
		Assert.assertEquals("Validate Test Case",osuser,osuser);
	}
   
	
	@Test
	public void saveTestCase()
	{
		osuser.setId(104);
		osuser.setName("bajajfour");
		osuser.setPassword("savendupdate");
		osuser.setMail_id("101@mahoo.com");
		osuser.setMobilenumber("5671544753");
		osuser.setRole("User");
		osuser.setUsername("new");
		
		Assert.assertEquals("saveTestCase", true, userDAO.update(osuser));
		
		
		
	}
}
