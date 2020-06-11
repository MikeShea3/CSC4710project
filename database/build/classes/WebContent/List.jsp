<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>People Management Application</title>
</head>
<body>
	
    <div align="center">
       <h3 align="center"> User Table </h3>

	<table border="1" width="70%" align="center">

	<tr>

	<th>Email</th>
	
	<th>Password</th>
	
	<th>Password Confirmed</th>
	
	<th>First Name</th>
	
	<th>Last Name </th>
	
	<th>Age</th>
	

	</tr>

	<c:forEach items="${listPeople}" var="user">

<tr>

<td>${user.email}</td>

<td>${user.password}</td>

<td>${user.passwordConfirmed}</td>

<td>${user.firstname}</td>

<td>${user.lastname}</td>

<td>${user.age}</td>

</tr>

</c:forEach>

</table>
    </div>   

</body>
</html>