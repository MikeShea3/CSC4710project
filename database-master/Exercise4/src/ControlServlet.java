

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
            	insertPeople(request, response);
                break;
            case "/delete":
            	deletePeople(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
            	updatePeople(request, response);
                break;
            default:          	
            	listPeople(request, response);           	
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    // Method to list all users in the table [Complete]
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<People> listPeople = peopleDAO.listAllPeople();
        request.setAttribute("listPeople", listPeople);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
    }
 
    // Method to insert a new user into the table [Complete]
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("InsertPeopleForm.jsp");
        dispatcher.forward(request, response);
    }
 
    // Method to display the EditPeopleForm.jsp [Complete]
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
    	String email = request.getParameter("email");
        People existingPeople = peopleDAO.getPeople(email);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPeopleForm.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
 
    }
 
    // Method to insert a new user to the table [Complete]
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String passwordConfirmed = request.getParameter("passwordConfirmed");
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	
        People newPeople = new People(email, password, passwordConfirmed, firstname, lastname, age);
        peopleDAO.insert(newPeople);
        response.sendRedirect("list");  // The sendRedirect() method works at client side and sends a new request
    }
 
    // Method to update an individual user in the table [Complete]
    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
  
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String passwordConfirmed = request.getParameter("passwordConfirmed");
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	
        People people = new People(email, password, passwordConfirmed, firstname, lastname, age);
        peopleDAO.update(people);
        response.sendRedirect("list");
    }
 
    // Method to delete a user from the table [Complete]
    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String email = request.getParameter("email");
       
        peopleDAO.delete(email);
        response.sendRedirect("list"); 
    }

}