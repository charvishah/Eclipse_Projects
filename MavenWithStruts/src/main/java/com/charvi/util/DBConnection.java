package com.charvi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

	Connection conn = null;
	String driver;
	String url;
	String userName;
	String password;

	public Connection getDBConnection() throws SQLException {
		try {
			// Step 7: Read the parameters required for connection
			loadDbProperties();
			Class.forName(driver); // loads the Driver class in memory
			conn = DriverManager.getConnection(url, userName, password);
			//give back the database connection object to the caller
			return conn;
		} catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		}
	}

	public void loadDbProperties() {
		// Step 8: Resource bundle looks for a file named dbParameters.properties in the classpath
		ResourceBundle labels = ResourceBundle.getBundle("com/charvi/properties/dbParameters");
		driver = labels.getString("DB_DRIVER");
		url = labels.getString("DB_URL");
		userName = labels.getString("DB_USER");
		password = labels.getString("DB_PASSWORD");
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception when trying to close data base connetion");
		}
	}

}