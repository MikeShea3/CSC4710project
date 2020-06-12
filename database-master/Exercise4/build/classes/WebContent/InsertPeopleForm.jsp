<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Application</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
             
        </h2>
    </center>
    <div align="center">
            <form action="insert" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                        Register a New User
                </h2>
            </caption>
                <c:if test="${people != null}">
                <%-- I don't understand what this is doing --%>
                    <input type="hidden" name="id" value="<c:out value='${people.id}' />" />
                </c:if>           
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="50"
                            value="<c:out value='${people.email}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="50"
                            value="<c:out value='${people.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password Confirmation: </th>
                <td>
                    <input type="text" name="passwordConfirmed" size="50"
                            value="<c:out value='${people.passwordConfirmed}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstname" size="50"
                            value="<c:out value='${people.firstname}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastname" size="50"
                            value="<c:out value='${people.lastname}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <th>Age: </th>
                <td>
                    <input type="text" name="age" size="50"
                            value="<c:out value='${people.age}' />"
                    />
                </td>
            </tr>
            
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
