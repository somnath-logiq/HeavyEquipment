package com.logiq.heavyequipment.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logiq.heavyequipment.delegate.UserDelegate;
import com.logiq.heavyequipment.domain.User;
import com.logiq.heavyequipment.entities.UserEntity;
import com.logiq.heavyequipment.enums.ErrorConstants;
import com.logiq.heavyequipment.exceptions.APIException;
import com.logiq.heavyequipment.mappers.UserMapper;
import com.logiq.heavyequipment.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDelegate userDelegate;
	
	@Override
	public void save(User user) {
		UserEntity userEntity = UserMapper.createUser(user);
		userDelegate.save(userEntity);
		
	}

	@Override
	public User get(String firstname) {
		if("Somnath".equalsIgnoreCase(firstname)) {
			throw new APIException(ErrorConstants.EXISTING_USER);
		}
		// DB Call
		//userDelegate;
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("Ram");
		User user = UserMapper.get(userEntity);
		return user;
	}
 
}
