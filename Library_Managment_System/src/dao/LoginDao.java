package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.LoginForm;

public class LoginDao {
	
	public boolean validate(LoginForm lf) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/library_managment", "root", "889325Ca");
        PreparedStatement ps=con.prepareStatement("select id from register where id=? and password=?");
        ps.setString(1, lf.getId());
        ps.setString(2, lf.getPassword());
        ResultSet rs=ps.executeQuery();
       if(rs.next())
    	   return true;
       else
    	   return false;			   
	}
}