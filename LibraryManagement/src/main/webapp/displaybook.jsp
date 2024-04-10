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
<link rel="stylesheet" href="css/table.css">
</head>
<body>



<% 

 BookDAOFactory bookDAOFactory=new BookDAOFactory();
 BookDAO bookDAO=bookDAOFactory.getBookDAO();

 List<Book> list=bookDAO.getAllBook();
 
 request.setAttribute("booklist", list);
 
 out.print(list);
%>
<h1>Library Management</h1>
<table class="grid-container" id="customers">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Number of Pages</th>
        <th>Price</th>
        <th>DELETE</th>
        <th>UPDATE</th>
    </tr>

    <c:forEach var="book" items="${requestScope.booklist}">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.noOfPages}"/></td>
            <td><c:out value="${book.price}"/></td>
            <td><a href="DeleteBook?id=${book.id}">DELETE</a></td>
            <td><a href="updatebook.jsp?id=${book.id}">UPDATE</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>