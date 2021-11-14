package com.example.demo.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Authors;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	
	
	
	
	
	
    // dependency Injection
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


















	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Authors author = new Authors("Eric","Know");
		Book b = new Book("allLies","2344");
		
		author.getBooks().add(b);
		b.getAuthors().add(author);
		
		authorRepository.save(author);
		bookRepository.save(b);
		
		Publisher publisher = new Publisher();
		publisher.setName("Nano");
		publisher.setCity("Ny");
		publisher.setState("CalState");
		publisher.setZip("110045");
		
		publisherRepository.save(publisher);
		
		b.setPublisher(publisher);
		publisher.getBooks().add(b);
		
		publisherRepository.save(publisher);
		
		
		
		System.out.println("book count"+ bookRepository.count());
		System.out.println("Publisher count"+publisherRepository.count());
		System.out.println("No of Books Publisher published:"+ publisher.getBooks().size());
		
	}
	
	

}
