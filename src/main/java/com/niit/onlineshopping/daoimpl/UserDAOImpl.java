package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.UserDAO;
import com.niit.onlineshopping.model.User;

@SuppressWarnings("deprecation")
@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	public SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<User> list() {
		String hql ="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
    @Transactional
	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
    @SuppressWarnings({ "rawtypes" })
	@Transactional
	public User validate(String username, String password) {
		String hql="from User where id='"+username+"' and password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();
	}

    @Transactional
	public boolean save(User user) {
		try{
		  sessionFactory.getCurrentSession().save(user);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	public User get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
