package com.example.lib.service;
import com.example.lib.model.Book;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookService {
	Book addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(long id);
	Book updateBookById(Book e, long id);
	void deleteBook(long id);
//	@Query("select u from Book where u.title =:x")
	public List<Book> searchBook(@Param("x") String title);
	
}
