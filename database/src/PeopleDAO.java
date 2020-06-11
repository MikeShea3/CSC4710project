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
	
	
	public PeopleDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "user=root&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public List<People> listAllPeople() throws SQLException {
        List<People> listPeople = new ArrayList<People>();        
        String sql = "SELECT * FROM user";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String email = resultSet.getString("email");
        	String password = resultSet.getString("password");
        	String passwordConfirmed = resultSet.getString("passwordConfirmed");
        	String firstname = resultSet.getString("firstname");
        	String lastname = resultSet.getString("lastname");
        	int age = resultSet.getInt("age");
        	
             
            People people = new People(email, password, passwordConfirmed, firstname, lastname, age);
            listPeople.add(people);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listPeople;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
         
    public boolean insert(People people) throws SQLException {
    	connect_func();         
		String sql = "insert into  student(email, password, passwordConfirmed, firstname, lastname, age) values (?, ?, ?, ?, ?, ?)";
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
        String sql = "update user set email=?, password =?,passwordConfirmed = ?, firstname = ?, lastname = ?, age = ? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, people.email);
		preparedStatement.setString(2, people.password);
		preparedStatement.setString(3, people.passwordConfirmed);
		preparedStatement.setString(4, people.firstname);
		preparedStatement.setString(5, people.lastname);
		preparedStatement.setInt(6, people.age);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
//        disconnect();
        return rowUpdated;     
    }
	
    public People getPeople(String email) throws SQLException {
    	People people = null;
        String sql = "SELECT * FROM user WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	String password = resultSet.getString("password");
        	String passwordConfirmed = resultSet.getString("passwordConfirmed");
        	String firstname = resultSet.getString("firstname");
        	String lastname = resultSet.getString("lastname");
        	int age = resultSet.getInt("age");
        	
             
            people = new People(email, password, passwordConfirmed, firstname, lastname, age);
        }
         
        resultSet.close();
        statement.close();
         
        return people;
    }
}
