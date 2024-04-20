package com.gl.min.pojo;
import java.sql.*;
public class UserDAO 
{
	Connection connection;
	public UserDAO() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated constructor stub
		String jdbcURL = "jdbc:mysql://localhost:3306/Mini_project";
        String dbUser = "root";
        String dbPassword = "Rekha@528";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	}
	public User checkLogin(String email, String password) throws SQLException,
	ClassNotFoundException 
	{

        String sql = "SELECT * FROM register WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        User user = null;
        if (result.next()) 
        {
            user = new User();
            user.setPassword(result.getString("password"));
            user.setEmail(email);
            return user;
        }
        
        return user;
    }

	private void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	private void setFullname(String string) {
		// TODO Auto-generated method stub
		
	}
} 