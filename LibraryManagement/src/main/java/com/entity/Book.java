package com.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "book")

public class Book implements Serializable
{
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "bId")
	private int id;
	@Column(name = "bTitle")
	private String title;
	@Column(name = "bAuthor")
	private String author;
	@Column(name = "bPages")
	private int noOfPages;
	@Column(name = "bPrice")
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, String author, int noOfPages, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.noOfPages = noOfPages;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", noOfPages=" + noOfPages + ", price="
				+ price + "]";
	}
	
	
	
}
