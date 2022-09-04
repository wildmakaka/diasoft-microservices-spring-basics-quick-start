package org.javadev.restservice.dao;

import org.javadev.restservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
