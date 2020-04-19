package com.logiq.heavyequipment.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class User {

	@NotEmpty(message = "first cannot be empty")
	private String firstName;
	
	private String lastName;
	
	private String aadharNumber;
	
	private String panCardNumber;
	
	private String Address;
	
	private String contactNumber;
	
	
}
