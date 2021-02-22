package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaBeans.User;

public class UserDAO implements UserService {
	
	private DbConfigDAO dbInstance;
	private Connection connection;

	
	public UserDAO() {
		dbInstance=DbConfigDAO.getInstance();
		try {
			connection = dbInstance.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//for login:
	@Override
	public User checkLogin(String email, String password) throws SQLException {
		
		String query = "SELECT * FROM user WHERE email = ? and password = ?";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1,email);
		preStat.setString(2,password);
		ResultSet result = preStat.executeQuery();
		
		User user = null;
		
		if(result.next()) {
			int id=result.getInt("id_user");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			String cin = result.getString("cin");
			String  accountType = result.getString("accountType");
			
			user = new User(id,cin,firstName,lastName,phone,email,password);
			user.setAccountType(accountType);
		}
		connection.close();
		return user;
	}
	//for register:
	@Override
	public boolean isExist(String email,String cin) throws SQLException {
		boolean exist = true;
		String query = "SELECT ID FROM USER WHERE email = ? and cin = ?";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, email);
		preStat.setString(2, cin);
		ResultSet resultSet = preStat .executeQuery();
		
		exist = resultSet.next() ? true : false ;
		preStat .close();
			
		return exist ;
	}

	@Override
	public int register(User user) throws SQLException {
	
			// connect to data base
			

			//prepare statements
			String insertQuery = "INSERT INTO USER (firstName,lastName,phone,email,password) VALUES (?,?,?,?,?)";
			String maxQuery = "SELECT MAX(id) AS MID FROM USER";
			PreparedStatement preStat = connection.prepareStatement(insertQuery);
			PreparedStatement ms = connection.prepareStatement(maxQuery);
			
			//set attributes
			preStat.setString(1, user.getFirstName());
			preStat.setString(2, user.getLastName());
			preStat.setString(3, user.getPhone());
			preStat.setString(4, user.getEmail());
			preStat.setString(5, user.getPassword());
			
			// Execute statements
			preStat.executeUpdate();
			
			//set The ID
			
			ResultSet resultSet = ms.executeQuery();
			if (resultSet.next()) {
				user.setId_user(resultSet.getInt("MID"));
			}
			
			// close statement
			preStat.close();
			return 0;
	}

}
