package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.CategoryDAO;
import com.niit.onlineshopping.model.Category;

@SuppressWarnings("deprecation")
@Repository
public class CategoryDAOImpl implements CategoryDAO  {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<Category> list() {
		String hql ="from Category";
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
		String hql = "from Category where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Category>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public boolean delete(Category category) {
		try {
			log.debug("Delete method Is Starting..........D.......! ");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Delete Method is Ending.........D.......!");
			return true;
		} catch (Exception e) {
			log.info("Exception Occureing Delete Method......D.....!" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
