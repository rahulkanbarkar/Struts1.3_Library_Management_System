package com.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class DbConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection con=null;
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/library_managment","root","889325Ca");
		}
		return con;
		
	}

}
