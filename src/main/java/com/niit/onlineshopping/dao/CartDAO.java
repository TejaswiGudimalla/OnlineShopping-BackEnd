package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Cart;

public interface CartDAO {
	
	public List<Cart> list();

	public boolean save(Cart cart);

	public boolean update(Cart cart);

	public boolean delete(Cart cart);

	public Cart get(int id);

	public Cart getProduct(int id);

	public long cartsize(int userid);

	public double cartprice(int userid);

	public void pay(int userid);

}
