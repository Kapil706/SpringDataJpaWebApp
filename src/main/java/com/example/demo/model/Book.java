package com.example.demo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	

	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id") , 
	inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Authors> authors = new HashSet<>();
	
	
	@ManyToOne
	private Publisher publisher;
	
	
	

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Book() {
		super();
	}

	public Book(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
		
	}

	
	 
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}
    
	
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", isbn=" + isbn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	
	
	
}
