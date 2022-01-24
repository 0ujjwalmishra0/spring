package com.example.lib.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.lib.exception.ResourceNotFoundException;
import com.example.lib.model.Book;
import com.example.lib.model.Fine;
import com.example.lib.model.Loan;
import com.example.lib.model.Role;
import com.example.lib.model.User;
import com.example.lib.repo.BookRepo;
import com.example.lib.repo.FineRepo;
import com.example.lib.repo.LoanRepo;
import com.example.lib.repo.RoleRepo;
import com.example.lib.repo.UserRepo;
import com.example.lib.service.UserService;
import java.sql.Date;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private LoanRepo loanRepo;
	@Autowired
	private FineRepo fineRepo;
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;



	@Override
	public User addUser(User user) {
		long millis=System.currentTimeMillis();  
        Date date=new java.sql.Date(millis); 
		user.setJoined_date(date);
		
		Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
		
        String password= user.getUserPassword();
		user.setUserPassword(getEncodedPassword(password));
		return userRepo.save(user);
	}
	
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepo.findById(String.valueOf(id)).orElseThrow(()->new ResourceNotFoundException("Book","ID",id));
	}

	@Override
	public User updateUserById(User user, long id) {
		User existingUser= userRepo.findById(String.valueOf(id)).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		existingUser.setName(user.getName());
		existingUser.setStatus(user.getStatus());
		//save to database
		userRepo.save(existingUser);
		return existingUser;
	}
	
	@Override
	public User makeAdmin(long id) {
		User existingUser= userRepo.findById(String.valueOf(id)).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		
		Role role = roleRepo.findById("Admin").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        existingUser.setRole(userRoles);
		userRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		User user= userRepo.findById(String.valueOf(id)).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		userRepo.delete(user);
	}
	
	public Loan issueBook(long book_id,long user_id) {
		Loan loan=new Loan();
		Book book= bookRepo.getById(book_id);
		int currentCopies= book.getCopies();
		int currentIssuedCopies= book.getIssuedCopies();
		if(currentCopies>1) {
			book.setCopies(currentCopies-1);
			book.setIssuedCopies(currentIssuedCopies+1);
		}
		else {
			throw new Error("0 copies remaining of this book");
		}
		
		long millis=System.currentTimeMillis();  
        Date date=new java.sql.Date(millis); 
		loan.setBookId(book_id);
		loan.setUserId(user_id);
		loan.setLoanDate(date);
		return loanRepo.save(loan);
	}

	@Override
	public Loan returnBook(long book_id, long user_id) {
		Loan loan= loanRepo.findByBookIdAndUserId(book_id, user_id);
		Book book= bookRepo.getById(book_id);
		int currentCopies= book.getCopies();
		int currentIssuedCopies= book.getIssuedCopies();
		long millis=System.currentTimeMillis();  
        Date date=new java.sql.Date(millis);
		loan.setBookId(book_id);
		loan.setUserId(user_id);
		loan.setReturnDate(date);
		long diff= Math.round((loan.getLoanDate().getTime() - date.getTime())/24*3600*1000);
		long fine= 3;
		if(diff>7) {
			fine= 5*(diff-7);
//			loan.setFine(fine);
//			updateFine(user_id,fine);
		}

		loan.setFine(fine);
		updateFine(user_id,fine);
		book.setIssuedCopies(currentIssuedCopies-1);
		book.setCopies(currentCopies+1);
		bookRepo.save(book);
		return loanRepo.save(loan);
	}

	@Override
	public User updateFine(long id, long fine) {
		User user= userRepo.getById(String.valueOf(id));
		user.setFine(fine);
		return userRepo.save(user);
	}

	@Override
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		return loanRepo.findAll();
	}
	
	public List<Fine> getAllFine(){
		return fineRepo.findAll();
	}

	@Override
	public Loan findLoan(long book_id, long user_id) {
		// TODO Auto-generated method stub
		return loanRepo.findByBookIdAndUserId(book_id, user_id);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public User getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

}
