package com.DAO;

import java.sql.SQLException;

import com.javaBeans.User;

public interface UserService {
	public User checkLogin(String email, String password) throws SQLException;
	public boolean isExist(String email) throws SQLException;
	public int register(User user) throws SQLException;
}
