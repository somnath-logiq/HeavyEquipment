package com.logiq.heavyequipment.services;

import com.logiq.heavyequipment.domain.User;

public interface UserService {

	void save(User user);

	User get(String firstName);

}
