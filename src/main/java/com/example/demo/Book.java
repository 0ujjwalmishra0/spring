package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Book {
	protected Book(){}
	
//	public Book(int id, String name, String author, String issueDate, String returnDate, Double price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.author = author;
//		this.issueDate = issueDate;
//		this.returnDate = returnDate;
//		this.price = price;
//	}
	int id;
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	String author;
	String issuedate;
	String returndate;
	Double price;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	
}