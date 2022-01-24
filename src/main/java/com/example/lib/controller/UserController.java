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
import com.example.lib.model.Fine;
import com.example.lib.model.Loan;
import com.example.lib.model.User;
import com.example.lib.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;


    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
	@PostMapping("addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("getAllUser")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("user")
	public User getUserByUserName(@RequestParam("userName") String userName) {
		return userService.getUserByUsername(userName);
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
	
	@PutMapping("makeAdmin")
	User makeAdmin(@RequestParam("userId") long userId) {
		return userService.makeAdmin(userId);
	}
	
}
