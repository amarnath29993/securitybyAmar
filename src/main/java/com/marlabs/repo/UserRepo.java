package com.marlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlabs.model.User;


public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserEmail(String userEmail);

}
