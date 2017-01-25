package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		//return (User) sessionFactory.getCurrentSession().get(User.class, id);
		String hql="from User where id="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if(list==null){
			return null;
		}else{
			return list.get(0);
		}
	}
    
    @Transactional
	public User validate(int id, String password) {
		String hql = "from user where id= '" + id + "' and password '" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}
	}

    @Transactional
	public boolean save(User user) {
		try{
		  sessionFactory.getCurrentSession().save(user);
		  return true;
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User get(String username) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("username", username));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}
	}

	

}
