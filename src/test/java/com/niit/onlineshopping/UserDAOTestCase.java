package com.niit.onlineshopping;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlineshopping.dao.UserDAO;
import com.niit.onlineshopping.model.User;

public class UserDAOTestCase {
	
	@Autowired
	 static  UserDAO userDAO;
	
	@Autowired
	 static User user;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineshopping");
		context.refresh();
		
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAOImpl");
    }
	
	@Test
	 public void getUserTestCase()
	 {
	   user = userDAO.get("niit");
		Assert.assertEquals("User Test Case","niit",user.getUsername());
	 } 
	
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",size, size);
	}
	
	@Test
	public void  getUserTestCase1()
	{
		user=userDAO.get("niit");
		Assert.assertNotNull("Get User Test Case",user);
		
	}
    
	@Test
	public void saveTestCase()
	{
		user.setName("Teja");
	    user.setMobilenumber("7676767676");
		user.setMail_id("teja@gmail.com");
		user.setPassword("teja");
	    user.setRole("Admin");
	    user.setUsername("teja");
	    user.setEnabled(true);
		
	    Assert.assertEquals("save Test Case",true,userDAO.save(user));
	}

    @Test
    public void validateCredentials()
    {
	    user=userDAO.validate(1,"niit");
	    Assert.assertNotNull("ValidateCredentials",user);
	}
    
    @Test
    public void invalidateCredentials()
    {
    	user=userDAO.validate(1,"niit@13");
    	Assert.assertNull("Invalid Credentials",user);
	}
}
