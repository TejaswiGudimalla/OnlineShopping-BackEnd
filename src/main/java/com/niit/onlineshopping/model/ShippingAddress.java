package com.niit.onlineshopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ShippingAddress")
@Component
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int shippingAddressId;
	
	private String name;
	
	private String doorNumber;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	@Override
	public String toString(){
		return name+","+doorNumber+","+street+","+city+","+state+","+pincode;
	}
	
	public int getShippingAddressId(){
		return shippingAddressId;
	}
	
}
