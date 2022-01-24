package com.example.lib.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	@PostMapping
    @PreAuthorize("hasRole('User')")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping
    @PreAuthorize("hasRole('User')")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/search")
    @PreAuthorize("hasRole('User')")
	public List<Book> search(@RequestParam("title") String title){
		return bookService.searchBook(title);
	}
	
	@GetMapping("/searchByAuthor")
    @PreAuthorize("hasRole('User')")
	public List<Book> searchBookByAuthor(@RequestParam("author") String author){
		return bookService.searchBookByAuthor(author);
	}
	
	@GetMapping("{id}")
    @PreAuthorize("hasRole('User')")
	public Book getBookById(@PathVariable("id") long id) {
		return bookService.getBookById(id);
	}
	
	@PutMapping("{id}")
    @PreAuthorize("hasRole('User')")
	public Book updateBook(@PathVariable("id") long id,@RequestBody Book book) {
		return bookService.updateBookById(book, id);
	}
	 
	@DeleteMapping("{id}")
    @PreAuthorize("hasRole('User')")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book deleted Sucessfully!",HttpStatus.OK);
	}

}
