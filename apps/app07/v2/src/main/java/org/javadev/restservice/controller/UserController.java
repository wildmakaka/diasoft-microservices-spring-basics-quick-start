package org.javadev.restservice.controller;

import java.util.List;

import org.javadev.restservice.entity.User;
import org.javadev.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/addUser")
	@ResponseStatus( HttpStatus.CREATED )
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users){
		return userService.createUsers(users);
	}
	

	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

} // The End of Class;
