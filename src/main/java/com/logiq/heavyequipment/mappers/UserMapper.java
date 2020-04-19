package com.logiq.heavyequipment.mappers;

import com.logiq.heavyequipment.domain.User;
import com.logiq.heavyequipment.entities.UserEntity;

public class UserMapper {

	public static UserEntity createUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("Test");
		return userEntity;
	}

	public static User get(UserEntity userEntity) {
		User user = new User();
		user.setFirstName(userEntity.getFirstName());
		return user;
	}

}
