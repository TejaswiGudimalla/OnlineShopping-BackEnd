package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.SupplierDAO;
import com.niit.onlineshopping.model.Supplier;

@SuppressWarnings("deprecation")
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	public SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional
	public List<Supplier> list() {
		String hql ="from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

    @Transactional
	public boolean save(Supplier supplier) {
		try{
		  sessionFactory.getCurrentSession().save(supplier);
		}
		catch (Exception e){
			e.printStackTrace();
			//This is used to know the error which will be displayed in the console. 
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    return true;
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public Supplier get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
