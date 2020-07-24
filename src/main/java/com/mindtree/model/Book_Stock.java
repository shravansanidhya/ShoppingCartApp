package com.mindtree.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book_Stock")
public class Book_Stock extends Product_Stock{

	private String genre;
	private String author;
	private String publications;
	
	public Book_Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book_Stock(String genre, String author, String publications) {
		super();
		this.genre = genre;
		this.author = author;
		this.publications = publications;
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

	@Override
	public String toString() {
		return "Book_Stock [genre=" + genre + ", author=" + author
				+ ", publications=" + publications + "]";
	}
	
}
