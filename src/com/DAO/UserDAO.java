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
		
		query = "SELECT * FROM USER WHERE email = ? and password = ?";
		this.connection=dbInstance.getConnection();
		preStat = connection.prepareStatement(query);
		preStat.setString(1,email);
		preStat.setString(2,password);
		result = preStat.executeQuery();
		
		User user = null;
		
		if(result.next()) {
			int id=result.getInt("id");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			
			user = new User(id,firstName,lastName,phone,email,password);
		}
		connection.close();
		return user;
	}
	//for register:
	public int register(User user) {

		try {
			// connect to data base
			dbInstance=DbConfigDAO.getInstance();
			Connection connection = dbInstance.getConnection();

			//prepare statements
			String insertQuery = "INSERT INTO USER (firstName,lastName,phone,email,password) VALUES (?,?,?,?,?)";
			String maxQuery = "SELECT MAX(id) AS MID FROM USER";
			PreparedStatement cs = connection.prepareStatement(insertQuery);
			PreparedStatement ms = connection.prepareStatement(maxQuery);

			//set attributes

			cs.setString(1, user.getFristName());
			cs.setString(2, user.getLastName());
			cs.setString(3, user.getPhone());
			cs.setString(4, user.getEmail());
			cs.setString(5, user.getPassword());

			// Execute statements

			cs.executeUpdate();

			//set The ID

			ResultSet resultSet = ms.executeQuery();
			if (resultSet.next()) {
				user.setId(resultSet.getInt("MID"));
			}

			// close statement
			cs.close();


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user.getId();
	}

	@Override
	public boolean isExist(String email) {
		boolean exist = true;
		try {
			// connect to data base
			dbInstance=DbConfigDAO.getInstance();
			Connection connection = dbInstance.getConnection();

			//prepare statements
			String fetchQuery = "SELECT ID FROM USER WHERE email = ? ";
			PreparedStatement cs = connection.prepareStatement(fetchQuery);

			//set attributes
			cs.setString(1, email);


			// Execute statements
			ResultSet resultSet = cs.executeQuery();

			exist = resultSet.next() ? true : false ;

			// close statement
			cs.close();


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return exist ;
	}

}
