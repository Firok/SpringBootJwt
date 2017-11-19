package com.firok.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firok.app.model.User;
import com.firok.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUserWithPagination(Pageable pageable) {

		// get all users with pagination
		Page<User> userPage = userService.findAllWithPagination(pageable);

		// wrapper user page list
		PageWrapper<User> pageWrapperUsers = new PageWrapper<>(userPage, "/users");

		log.info("All users ='{}'", pageWrapperUsers.getContent());

		return pageWrapperUsers.getContent();

	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.save(user);

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {

		User user = userService.find(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user){
		return userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id){
		userService.delete(id);
	}

}
