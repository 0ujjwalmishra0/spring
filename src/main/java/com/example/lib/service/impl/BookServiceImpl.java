package com.example.lib.service.impl;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.lib.exception.ResourceNotFoundException;
import com.example.lib.model.Book;
import com.example.lib.repo.BookRepo;
import com.example.lib.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	private BookRepo bookRepo;
	public BookServiceImpl(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(long id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book","ID",id));
	}

	@Override
	public Book updateBookById(Book e, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(long id) {
		
	}

	@Override
	public List<Book> searchBook(String title) {
		// TODO Auto-generated method stub
		return bookRepo.findByTitle(title);
	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepo.findByAuthor(author);
	}
	
	


}
