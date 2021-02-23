package com.DAO;

import java.sql.SQLException;

import com.javaBeans.Patient;
import com.javaBeans.User;

public interface UserService {
	public User checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email,String cin) throws SQLException;
	public int register(Patient patient) throws SQLException;
}
