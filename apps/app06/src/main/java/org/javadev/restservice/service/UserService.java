package org.javadev.restservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.javadev.restservice.dao.UserRepository;
import org.javadev.restservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User updateUser(User user) {
		User oldUser = null;
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if (optionalUser.isPresent()) {
			oldUser = optionalUser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		} else {
			return new User();
		}
		return oldUser;
	}
	
	@Transactional
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User deleted!";
	}


} // The End of Class;
