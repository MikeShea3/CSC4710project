<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User Table</title>
</head>
<body>

<%-- This grabs the list of people if the page is currently blank such as when first loading the page
	but it requires an import of PeopleDAO, which cannot happen while PeopleDAO is inside the default package. Moving PeopleDAO
	outside of the main package requires moving other classes as well, which breaks the program. --%>

<%--
if(request.getParameter("listPeople") == null) { 
	PeopleDAO peopleDAO = new PeopleDAO();       
	List<People> listPeople = peopleDAO.listAllPeople();
	request.setAttribute("listPeople", listPeople);       
}
--%>

    <center>
        <h1>User Table</h1>
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
       			<th>Email</th>
       			<th>Password</th>
       			<th>Password Confirmed</th>
       			<th>First Name</th>
       			<th>Last Name</th>
       			<th>Age</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="people" items="${listPeople}">
                <tr>
                	<td><c:out value="${people.email}" /></td>
                	<td><c:out value="${people.password}" /></td>
                	<td><c:out value="${people.passwordConfirmed}" /></td>
					<td><c:out value="${people.firstname}" /></td>
					<td><c:out value="${people.lastname}" /></td>
					<td><c:out value="${people.age}" /></td>
                    <td>
                        <a href="edit?email=<c:out value='${people.email}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?email=<c:out value='${people.email}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>