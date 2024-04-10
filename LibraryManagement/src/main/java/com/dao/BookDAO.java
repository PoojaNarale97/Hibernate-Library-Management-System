
package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDAO {

	void saveBook(Book book);

	void deleteBook(Book book);

	void updateBook(Book book);

	Book getBook(Book book);

	List<Book> getAllBook();

}
