package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.BookRepository;

@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	
	
	
	
	//dependency injection
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}






	@RequestMapping("/books")
	private String getBooks(Model model) {
		
		
		
		model.addAttribute("books", bookRepository.findAll()); 
		
		
		return "books/list";  // it will return the list of books  .. first finds thymeleaf template with books and put the 
		
	}

}
