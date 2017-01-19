package com.niit.onlineshopping.model;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

public class BillingAddress {
	private static final long serialVersionUID=1L;
	
	@Id
	private String billingAddressId;
	
	@NotBlank(message="H.No/Flat No")
	private String line1;
	
	@NotBlank(message="Area")
	private String line2;
	
	@NotBlank(message="specify city")
	private String city;
	
	@NotBlank(message="specify state")
	private String state;

	@NotBlank(message="specify country")
	private String country;
	
	@NotBlank(message="specify pncode")
	private String pincode;
}
