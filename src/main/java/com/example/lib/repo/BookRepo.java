package com.example.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lib.model.Book;
import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long>{
//	@Query("select u from Book where u.title =:x")
	@Query(value= "select * from book where title =:x",nativeQuery = true)
	public List<Book> searchBookByTitle(@Param("x") String title);
}
