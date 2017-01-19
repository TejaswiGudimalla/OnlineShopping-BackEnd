package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.CategoryDAO;
import com.niit.onlineshopping.model.Category;

@SuppressWarnings("deprecation")
@Repository
public class CategoryDAOImpl implements CategoryDAO  {
	
	@Autowired
	public SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<Category> list() {
		String hql ="from category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
    
    @Transactional
	public boolean save(Category category) {
		try{
		  sessionFactory.getCurrentSession().save(category);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
