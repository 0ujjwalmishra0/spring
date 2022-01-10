package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LibService {
	@Autowired
    private LibRepo repo;
     
    public List<Book> listAll() {
        return repo.findAll();
    }
     
    public void save(Book product) {
        repo.save(product);
    }
     
    public Book get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}
