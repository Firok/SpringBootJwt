package com.firok.app.service;

import org.springframework.stereotype.Service;

import com.firok.app.model.User;

@Service
public interface UserService extends BaseService<User, Long> {
     
	/**
	 * find user by user name and password 
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);
}
