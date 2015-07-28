package com.charvi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.charvi.exception.ServiceException;
import com.charvi.util.DBConnection;


/**
 *This class interacts with the database and fetches the password and returns to LoginService class.
 */
public class UserDao {

	Connection con;
	PreparedStatement stmt;
	DBConnection dbConn = new DBConnection();

	public String getUserPassword(String userName) {
		
		String passwordFromDB = null;
		try {
			con = dbConn.getDBConnection();
			String sql = "SELECT user_password FROM  USER where user_name = ? ";
			stmt = con.prepareStatement(sql); // connection gives us any kind of stmnt. here it is prep stmnt
			stmt.setString(1, userName);	// sets the user name dynamically at the first ? sign

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				passwordFromDB = res.getString("USER_PASSWORD");  // retrieves password from the result set
			}
			
			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException();
		}
		return passwordFromDB;
	}
	
	

	public String getUserName(String userName){
		
		String usernameFromDB = null;
		try {
			con = dbConn.getDBConnection();
			String sql = "SELECT user_name FROM  USER where user_name = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);	// sets the user name dynamically at the first ? sign

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				usernameFromDB = res.getString("USER_NAME");  // retrieves password from the result set
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException();
		}
		finally{
			dbConn.closeConnection();
		}
		return usernameFromDB;
	}



	public void registerUser(String username, String password) {
		try {
			con = dbConn.getDBConnection();
			String sql = "INSERT INTO USER(USER_NAME, USER_PASSWORD) VALUES (?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);	// sets the user name dynamically at the first ? sign
			stmt.setString(2, password);	// sets the user name dynamically at the first ? sign
			stmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException();
		}
		finally{
			dbConn.closeConnection();
		}
		
	}

}
