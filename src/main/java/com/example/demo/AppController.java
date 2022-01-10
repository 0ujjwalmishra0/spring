package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
	@Autowired
	public LibService service;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		List<Book> books= service.listAll();
		model.addAttribute("books", books);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Book book= new Book();
	    model.addAttribute("book", book);
	     
	    return "new_book";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("book") Book book) {
	    service.save(book);
	     
	    return "redirect:/";
	}
	
}
