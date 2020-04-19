package com.logiq.heavyequipment.delegate.impl;

import org.springframework.stereotype.Service;

import com.logiq.heavyequipment.delegate.UserDelegate;
import com.logiq.heavyequipment.entities.UserEntity;
import com.logiq.heavyequipment.enums.ErrorConstants;
import com.logiq.heavyequipment.exceptions.ProcessingException;

@Service
public class UserDelegateImpl implements UserDelegate{

	//@Autowired
	//UserRepository userRepository;
	
	@Override
	public UserEntity save(UserEntity userEntity) {
		try {
			// only one line in this method
			//database call userRepository.save()
		}catch(Exception e) {
			throw new ProcessingException(ErrorConstants.EXISTING_USER);
		}
		return null;
	}

}
