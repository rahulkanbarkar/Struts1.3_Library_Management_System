 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connection.DbConnection;

import beans.Admin;

public class AdminDao  extends DbConnection{
	public int save(Admin e) throws Exception {
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("insert into register" + "(id,firstname,lastname,dob,age,city,password) values" +"(?,?,?,?,?,?,?);");
        ps.setString(1,e.getId());
        ps.setString(2,e.getLastname());
        ps.setString(3,e.getLastname());
        ps.setString(4, e.getDob());
        ps.setString(5, e.getAge());
        ps.setString(6, e.getCity());
        ps.setString(7, e.getPassword());
        int i=ps.executeUpdate();
        con.close();
        return i;    
	}
	

	public ResultSet reglist()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from register");       
       ResultSet rs= ps.executeQuery();
       return rs;
       }
	
	
	
	

}