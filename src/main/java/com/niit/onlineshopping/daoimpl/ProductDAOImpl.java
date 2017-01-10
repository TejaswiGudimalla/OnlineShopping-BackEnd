package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.ProductDAO;
import com.niit.onlineshopping.model.Product;

@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<Product> list() {
		String hql ="from product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
    
    @Transactional
	public boolean save(Product product) {
		try{
		  sessionFactory.getCurrentSession().save(product);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

}
