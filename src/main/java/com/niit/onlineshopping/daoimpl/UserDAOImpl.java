package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.UserDAO;
import com.niit.onlineshopping.model.OSUser;

@SuppressWarnings("deprecation")
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<OSUser> list() {
		String hql ="from osuser";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
    @Transactional
	public OSUser get(int id) {
		return (OSUser) sessionFactory.getCurrentSession().get(OSUser.class, id);
	}
    @SuppressWarnings({ "rawtypes" })
	@Transactional
	public OSUser validate(String username, String password) {
		String hql="from OSUser where id='"+username+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (OSUser)query.uniqueResult();
	}

    @Transactional
	public boolean save(OSUser osuser) {
		try{
		  sessionFactory.getCurrentSession().save(osuser);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(OSUser osuser) {
		try {
			sessionFactory.getCurrentSession().update(osuser);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	public OSUser get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
