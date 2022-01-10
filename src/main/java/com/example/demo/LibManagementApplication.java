package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.example.demo.LibServices"})
public class LibManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibManagementApplication.class, args);
	}

}
