package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOFactory;
import com.entity.Book;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookDAOFactory bookDAOFactory;
	@Override
	public void init() throws ServletException {
	       bookDAOFactory=new BookDAOFactory();
	}

    public DeleteBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int id=Integer.parseInt(request.getParameter("id"));
	
		Book book=new Book();
		book.setId(id);
		
		BookDAO bookDAO=bookDAOFactory.getBookDAO();
		
		bookDAO.deleteBook(book);
		
		request.getRequestDispatcher("/displaybook.jsp").forward(request, response);
		


	}

}
