package com.firok.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firok.app.dao.UserRepository;
import com.firok.app.model.User;
import com.firok.app.service.UserService;

@Repository
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	protected JpaRepository<User, Long> getRepository() {
		return userRepository;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	

}
