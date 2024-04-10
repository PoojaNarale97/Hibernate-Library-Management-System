package com.dao;

public class BookDAOFactory {
	
	public BookDAO getBookDAO() {
		return new BookDAOImpl();
	}



}
