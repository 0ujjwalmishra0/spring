package com.example.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lib.model.User;

public interface UserRepo extends JpaRepository<User, String>{
	public User findByUserName(String userName);
}
