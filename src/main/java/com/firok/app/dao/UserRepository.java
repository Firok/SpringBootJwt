package com.firok.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firok.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * find user by user name and password 
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);
}
