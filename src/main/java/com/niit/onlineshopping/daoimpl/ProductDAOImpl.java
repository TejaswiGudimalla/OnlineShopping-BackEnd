package com.niit.onlineshopping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlineshopping.dao.ProductDAO;
import com.niit.onlineshopping.model.Product;

@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(Product product) {
		try {
			//log.debug("Save method Is Starting");
			sessionFactory.getCurrentSession().save(product);
			//log.debug("Save Method is Ending");
			return true;
		} catch (Exception e) {
			//log.info("Exception Occureing save Method" + e.getMessage());
			e.printStackTrace();
			return false;
		}
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

	@Transactional
	public boolean delete(Product product) {
		try {
			log.debug("Delete method Is Starting");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Delete Method is Ending");
			return true;
		} catch (Exception e) {
			log.info("Exception Occureing Delete Method......D.....!" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public Product get(int id) {
		log.debug("starting of the method get");
		log.info("trying to get product based on id:" + id);
		String hql = "from Product where id= " + "'" + id + "'";
		log.info("the hsql query is :" + hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();

		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Product> getproduct(int id) {
		String hql = "from Product where id= " + "'" + id + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listProduct = (List<Product>) query.list();
		return listProduct;
	}

	@Transactional
	public List<Product> navproduct(int id) {
		String hql = "from Product where category_id= " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> CartProducts = (List<Product>) query.list();
		return CartProducts;
	}

}
