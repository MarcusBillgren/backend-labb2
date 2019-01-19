package com.billgren.lernia.labb2.labb2_test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	//command to test get all users curl -i http://localhost:8080/backend-labb2/UserService/users
	public List<User> getAllUsers() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		ArrayList<User> allUsers = new ArrayList<>();
		//get all users from database
		try {
			Driver driver = (Driver) Class.forName("org.mariadb.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.56.101:3306/backend_labb2?user=marcus&password=marcus");
			String query = "SELECT * FROM users";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
					
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String profession = rs.getString(3);
				allUsers.add(new User(id, name, profession));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUsers;
	}
	
	public void addAllUsers(List<User> listToadd) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		try {
			Driver driver = (Driver) Class.forName("org.mariadb.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.56.101:3306/backend_labb2?user=marcus&password=marcus");
			String query = "INSERT into users (name, profession) VALUES(?,?)";
			
			for(User u : listToadd) {
				
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setString(1, u.getName());
				pstmt.setString(2, u.getProfession());
				pstmt.execute();
			}
			


			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//save user list to database
		//return null;
	}
	

}
