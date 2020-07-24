package com.mindtree.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String genre;
	private String author;
	private String publications;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int prodId, String prodName, float price, int quantity) {
		super(prodId, prodName, price, quantity);
		// TODO Auto-generated constructor stub
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublications() {
		return publications;
	}
	public void setPublications(String publications) {
		this.publications = publications;
	}
	
	
}
