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

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookDAOFactory bookDAOFactory;

	
	@Override
	public void init() throws ServletException {
	       bookDAOFactory=new BookDAOFactory();
	}

    
    public AddBook() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
			response.setContentType("text/html");
			
			
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			int noOfPages = Integer.parseInt(request.getParameter("noOfPages"));
			double price = Double.parseDouble(request.getParameter("price"));

			// Create a new Book object with the provided data
			Book book = new Book(id, title, author, noOfPages, price);
			
			// In Ordert to save This Object
			//We need saveEmployee And Save Employee is present in EmployeeDAO
			// But EmployeeDAO is an INterface
			// We get an implementation of EmployeeDAO  from EmployeeDAOFactory
			BookDAO bookDAO=bookDAOFactory.getBookDAO();
			
			bookDAO.saveBook(book);
			
			request.getRequestDispatcher("/displaybook.jsp").forward(request, response);
			


	}

}
