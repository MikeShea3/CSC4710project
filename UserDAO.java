package projectpart1;

import java.sql.*;

public class UserDAO {
 
    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        String mysqlURL = "jdbc:mysql://127.0.0.1:3306/testdb?";
        String username = "john";
        String dbpassword = "pass1234";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(mysqlURL, username, dbpassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setFirstname(result.getString("firstname"));
            user.setLastname(result.getString("lastname"));
            user.setEmail(email);
        }
 
        connection.close();
 
        return user;
    }
}