package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
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
	
	//private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		try {
			System.out.println("save method is executed in supplier");
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

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

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Supplier get(int id) {
		String hql = "from Supplier where id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

}
