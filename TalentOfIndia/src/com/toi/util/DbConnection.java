package com.toi.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	static Properties prop;
	 Connection con;
	static {
		prop = new Properties();
		// loading properties from db.properties file
		// using classpath
		try {
			InputStream in = DbConnection.class.getResourceAsStream("/db.properties");
			prop.load(in);
			System.out.println("properties loaded.");
		} catch (Exception e) {
			System.out.println("Internal System Error");
		}
	}

	public  Connection getConnection() {
		if (con == null) {
			try {
				 Class.forName(prop.getProperty("driverClass"));
					con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
							prop.getProperty("password"));
			    }
				catch (Exception c)
			   {
		    	c.printStackTrace();
			   }
			return con;
		} else {
			return con;
		}
	}

	public  void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}