package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.AuthorRepository;

@Controller
public class AuthorController {
	
	
	
	private final AuthorRepository authorRepository;
	
	
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


    @RequestMapping("/authors")
	private String getAuthors(Model model) {
		
		
		model.addAttribute("authors", authorRepository.findAll());
		
		
		return "authors/list";
		
		
		
	}

}
