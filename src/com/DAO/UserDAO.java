package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaBeans.User;

public class UserDAO implements UserService {
	
	private DbConfigDAO dbInstance;
	private Connection connection;
	private PreparedStatement preStat;
	private ResultSet result;
	private String query;
	
	public UserDAO() {
		dbInstance=DbConfigDAO.getInstance();
		
	}
	//for login:
	@Override
	public User checkLogin(String email, String password) throws SQLException {
		
		query = "SELECT * FROM user WHERE email = ? and password = ?";
		this.connection=dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		preStat.setString(1,email);
		preStat.setString(2,password);
		result = preStat.executeQuery();
		
		User user = null;
		
		if(result.next()) {
			int id=result.getInt("id_user");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			
			user = new User(id,firstName,lastName,phone,email,password);
		}
		connection.close();
		return user;
	}
	//for register:
	@Override
	public boolean isExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int register(User user) throws SQLException {
	
			// connect to data base
			connection = dbInstance.getConnection();

			//prepare statements
			String insertQuery = "INSERT INTO USER (firstName,lastName,phone,email,password) VALUES (?,?,?,?,?)";
			String maxQuery = "SELECT MAX(id) AS MID FROM USER";
			preStat = connection.prepareStatement(insertQuery);
			PreparedStatement ms = connection.prepareStatement(maxQuery);
			
			//set attributes
			preStat.setString(1, user.getFristName());
			preStat.setString(2, user.getLastName());
			preStat.setString(3, user.getPhone());
			preStat.setString(4, user.getEmail());
			preStat.setString(5, user.getPassword());
			
			// Execute statements
			preStat.executeUpdate();
			
			//set The ID
			
			ResultSet resultSet = ms.executeQuery();
			if (resultSet.next()) {
				user.setId(resultSet.getInt("MID"));
			}
			
			// close statement
			preStat.close();
			return 0;
	}

}
