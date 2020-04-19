package com.logiq.heavyequipment.domain.request;

import javax.validation.Valid;

import com.logiq.heavyequipment.domain.User;

import lombok.Data;

@Data
public class UserRequest {

	@Valid
	private User user;
	
	
}
