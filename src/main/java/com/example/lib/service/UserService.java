package com.example.lib.service;

import java.util.List;
import com.example.lib.model.Fine;
import com.example.lib.model.Loan;
import com.example.lib.model.User;

public interface UserService {

	User addUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User getUserByUsername(String userName);
	User updateUserById(User u,long id);
	String deleteUser(long id);
	Loan issueBook(long book_id,long user_id);
	Loan returnBook(long book_id,long user_id);
	User updateFine(long id,long fine);
	List<Loan> getAllLoans();
	List<Fine> getAllFine();
	Loan findLoan(long book_id,long user_id);
	User makeAdmin(long id);
}
