package com.example.lib.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lib.model.Book;
import com.example.lib.repo.BookRepo;
import com.example.lib.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private BookService bookService;
	private BookRepo bookRepo;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	@PostMapping
	public ResponseEntity<Book> saveEmployee(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/search")
	public List<Book> search(@RequestParam("title") String title){
		return bookService.searchBook(title);
		//return bookRepo.searchBookByTitle(title); 
	}
	
	@GetMapping("{id}")
	public Book getBookById(@PathVariable("id") long id) {
		return bookService.getBookById(id);
	}
	
	@PutMapping("{id}")
	public Book updateBook(@PathVariable("id") long id,@RequestBody Book book) {
		return bookService.updateBookById(book, id);
	}
	 
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book deleted Sucessfully!",HttpStatus.OK);
	}

}