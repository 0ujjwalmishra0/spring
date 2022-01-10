package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibRepo extends JpaRepository<Book, Integer> {
	 
}