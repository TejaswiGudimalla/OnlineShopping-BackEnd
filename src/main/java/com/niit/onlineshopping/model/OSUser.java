package com.niit.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="OSUser")
@Component
public class  OSUser {
	@Id
	private String id;
	
	@Min(8)
	@Max(15)
	private String password;
	
	@NotEmpty(message="Enter Name")
	private String name;
	
	private String mobilenumber;
	private String role;
	private String mail_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	
	public String getId(){
		return id;
	}
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	
}