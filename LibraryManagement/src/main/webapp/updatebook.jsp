<%@page import="com.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.BookDAO"%>
<%@page import="com.dao.BookDAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
	
		Book book=new Book();
		book.setId(id);
%>

<%
BookDAOFactory bookDAOFactory=new BookDAOFactory();
BookDAO bookDAO=bookDAOFactory.getBookDAO();

Book book2=bookDAO.getBook(book);
request.setAttribute("book", book2);


%>

<form action="UpdateBook" method="get" class="form">
    Id: <input type="text" name="id" value="${requestScope.book.id}"> <br>
    Title: <input type="text" name="title" value="${requestScope.book.title}"> <br>
    Author: <input type="text" name="author" value="${requestScope.book.author}"> <br>
    Number of Pages: <input type="text" name="noOfPages" value="${requestScope.book.noOfPages}"> <br>
    Price: <input type="text" name="price" value="${requestScope.book.price}"> <br>
    <input type="submit" value="UPDATE">
</form>

</body>
</html>