

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/PeopleDAO")
public class PeopleDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// Method to initialize a PeopleDAO object [Complete]
	public PeopleDAO() {

    }
	       
	// Method to connect to the database [Complete]
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    // Method to list all members of the User database [Complete]
    public List<People> listAllPeople() throws SQLException {
        List<People> listPeople = new ArrayList<People>();        
        String sql = "SELECT * FROM user";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	// Query every entity for data
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String passwordConfirmed = resultSet.getString("passwordConfirmed");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            int age = resultSet.getInt("age");
            
            // Create object from queried data
            People people = new People(email, password, passwordConfirmed, firstname, lastname, age);
            listPeople.add(people);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listPeople;
    }
    
    // Method to disconnect from the MySQL server [Complete]
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
         
    
    // Method to insert a user into the table [Complete]
    public boolean insert(People people) throws SQLException {
    	connect_func();       
    	String sql = "insert into user(email, password, passwordConfirmed, firstname, lastname, age) values (?,?,?,?,?,?)";
    	
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, people.email);
		preparedStatement.setString(2, people.password);
		preparedStatement.setString(3, people.passwordConfirmed);
		preparedStatement.setString(4, people.firstname);
		preparedStatement.setString(5, people.lastname);
		preparedStatement.setInt(6, people.age);
//		preparedStatement.executeUpdate();
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowInserted;
    }     
     
    // Method to delete a user from the table [Complete]
    public boolean delete(String email) throws SQLException {
    	
        String sql = "DELETE FROM user WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowDeleted;     
    }
     
    public boolean update(People people) throws SQLException {
        String sql = "update user set email = ?, password=?, passwordConfirmed=?, firstname=?, lastname=?, age=? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        
        preparedStatement.setString(1, people.email);
        preparedStatement.setString(2, people.password);
        preparedStatement.setString(3, people.passwordConfirmed);
        preparedStatement.setString(4, people.firstname);
        preparedStatement.setString(5, people.lastname);
        preparedStatement.setInt(6, people.age);
        preparedStatement.setString(7, people.email);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowUpdated;     
    }
	
    public People getPeople(String email) throws SQLException {
    	System.out.println("GET PEOPLE EMAIL: " + email);
    	
    	People people = null;
        String sql = "SELECT * FROM user WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String passwordConfirmed = resultSet.getString("passwordConfirmed");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            int age = Integer.parseInt(resultSet.getString("age"));
             
            people = new People(email, password, passwordConfirmed, firstname, lastname, age);
        }
         
        resultSet.close();
        statement.close();
         
        return people;
    }
}
