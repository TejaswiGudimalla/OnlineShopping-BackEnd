package com.niit.onlineshopping.dao;

import java.util.List;

import com.niit.onlineshopping.model.Cart;

public interface CartDAO {
	
	public List<Cart> list();

	public boolean saveorupdate(Cart cart);

	public boolean update(Cart cart);

	public boolean delete(Cart cart);

	public List<Cart> get(int userid);

	public Cart getProduct(int productid, int userid);
	
	//public Cart getUser(int id);

	public long cartsize(int userid);

	public double cartprice(int userid);
	
	public Cart getitem(int cartId);

	public void pay(int userid);

}
