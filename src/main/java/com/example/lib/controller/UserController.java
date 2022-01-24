package com.example.lib.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lib.model.Book;
import com.example.lib.model.Fine;
import com.example.lib.model.Loan;
import com.example.lib.model.User;
import com.example.lib.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;


	@PostMapping("addUser")
    @PreAuthorize("hasRole('Admin')")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/user/update/{id}")
    @PreAuthorize("hasRole('User')")
	public User updateUser(@PathVariable("id") long id,@RequestBody User user) {
		return userService.updateUserById(user, id);
	}
	
	@PutMapping("/user/delete/{id}")
    @PreAuthorize("hasRole('User')")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "user has been deleted!";
	}
	
	@GetMapping("getAllUser")
    @PreAuthorize("hasRole('User')")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("user/{id}")
    @PreAuthorize("hasRole('User')")
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("user")
    @PreAuthorize("hasRole('User')")
	public User getUserByUserName(@RequestParam("userName") String userName) {
		return userService.getUserByUsername(userName);
	}
	
	
	@PostMapping("issueBook")
    @PreAuthorize("hasRole('User')")
	Loan issueBook(@RequestParam("userId") long userId,@RequestParam("bookId") long bookId) {
		return userService.issueBook(bookId, userId);
	}
	
	@PutMapping("returnBook")
    @PreAuthorize("hasRole('User')")
	Loan returnBook(@RequestParam("userId") long userId,@RequestParam("bookId") long bookId) {
		return userService.returnBook(bookId, userId);
	}
	
	@GetMapping("loans")
    @PreAuthorize("hasRole('User')")
	List<Loan> getAllLoans(){
		return userService.getAllLoans();
	}
	
	@GetMapping("loan")
    @PreAuthorize("hasRole('User')")
	Loan getLoan(@RequestParam("userId") long userId, @RequestParam("bookId") long bookId){
		return userService.findLoan(bookId, userId);
	}
	
	@GetMapping("fine")
    @PreAuthorize("hasRole('User')")
	List<Fine> getAllFines(){
		return userService.getAllFine();
	}
	
	@PutMapping("makeAdmin")
    @PreAuthorize("hasRole('User')")
	User makeAdmin(@RequestParam("userId") long userId) {
		return userService.makeAdmin(userId);
	}
	
}
