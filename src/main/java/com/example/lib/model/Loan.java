package com.example.lib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;
@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	long id;
	long bookId;
	long userId;
	Date loanDate;
	Date returnDate;
	long fine;
	
	public long getFine() {
		return fine;
	}
	public void setFine(long fine) {
		this.fine = fine;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
