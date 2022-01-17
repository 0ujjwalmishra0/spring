package com.example.lib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class Fine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long book_id;
	private long user_id;
	private long loan_date;
	private Date return_date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getLoan_date() {
		return loan_date;
	}
	public void setLoan_date(long loan_date) {
		this.loan_date = loan_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public long getFine_amount() {
		return fine_amount;
	}
	public void setFine_amount(long fine_amount) {
		this.fine_amount = fine_amount;
	}
	private long fine_amount;
}
