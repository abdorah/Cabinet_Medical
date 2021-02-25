
package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaBeans.Patient;
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
			int id = result.getInt("id_user");
			String firstName = result.getString("firstName");
			String lastName = result.getString("lastName");
			String phone = result.getString("phone");
			String cin = result.getString("cin");
			String  accountType = result.getString("accountType");
			
			user = new User(id,cin,firstName,lastName,phone,email,password);
			user.setAccountType(accountType);
		}

		preStat.close();

		return user;
	}
	//for register:
	@Override
	public boolean isExist(String email,String cin) throws SQLException {
		boolean exist = true;
		String query = "SELECT id_user FROM user WHERE email = ? and cin = ?";
		PreparedStatement preStat = connection.prepareStatement(query);
		preStat.setString(1, email);
		preStat.setString(2, cin);
		ResultSet resultSet = preStat .executeQuery();
		
		exist = resultSet.next() ? true : false ;
		preStat .close();
			
		return exist ;
	}

	@Override
	public int register(Patient patient) throws SQLException {

			/*/
			 * insert the patient in the table user:
			 */
			String userQuery = "INSERT INTO user (firstName,lastName,phone,email,password,cin) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement preStatOfUser = connection.prepareStatement(userQuery);
			
			
			//set attributes
			preStatOfUser.setString(1, patient.getFirstName());
			preStatOfUser.setString(2, patient.getLastName());
			preStatOfUser.setString(3, patient.getPhone());
			preStatOfUser.setString(4, patient.getEmail());
			preStatOfUser.setString(5, patient.getPassword());
			preStatOfUser.setString(6, patient.getCin());
			
			preStatOfUser.executeUpdate();
			
			String maxQuery = "SELECT MAX(id_user) AS MID FROM user";
			PreparedStatement ms = connection.prepareStatement(maxQuery);
			ResultSet resultSet = ms.executeQuery();
			if (resultSet.next()) {
				patient.setId_user(resultSet.getInt("MID"));
			}
			
			/*/
			 * insert the patient in the table patient:
			 */
			String patientQuery = "INSERT INTO patient (id_patient,BirthDate,sex) VALUES (?,?,?)";
			
			PreparedStatement preStatOfpatient = connection.prepareStatement(patientQuery);
			
			preStatOfpatient.setInt(1, patient.getId_user());
			preStatOfpatient.setString(2, patient.getBirthDate());
			preStatOfpatient.setString(3, patient.getSex());
			
			// Execute statements
			preStatOfpatient.executeUpdate();
			
			// close statement
			preStatOfpatient.close();
			preStatOfUser.close();
			return 0;
	}

}
