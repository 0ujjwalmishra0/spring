package com.example.lib.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lib.model.Fine;
import com.example.lib.model.Loan;
import com.example.lib.model.User;
import com.example.lib.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@PostMapping("issueBook")
	Loan issueBook(@RequestParam("userId") long userId,@RequestParam("bookId") long bookId) {
		return userService.issueBook(bookId, userId);
	}
	
	@PutMapping("returnBook")
	Loan returnBook(@RequestParam("userId") long userId,@RequestParam("bookId") long bookId) {
		return userService.returnBook(bookId, userId);
	}
	
	@GetMapping("loans")
	List<Loan> getAllLoans(){
		return userService.getAllLoans();
	}
	
	@GetMapping("loan")
	Loan getLoan(@RequestParam("userId") long userId, @RequestParam("bookId") long bookId){
		return userService.findLoan(bookId, userId);
	}
	
	@GetMapping("fine")
	List<Fine> getAllFines(){
		return userService.getAllFine();
	}
	
}
