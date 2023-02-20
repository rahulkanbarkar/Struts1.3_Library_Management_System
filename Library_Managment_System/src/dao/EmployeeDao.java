package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.connection.DbConnection;

import beans.Employee;
import beans.Library;

public class EmployeeDao extends DbConnection  {
	public int save(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?)");		
		ps.setString(1, e.getUserid());
		ps.setString(2, e.getUsername());		
		int i=ps.executeUpdate();
		con.close();
		return i;		
	}
	
	public boolean update(Employee e)throws Exception{
	
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update user set empname=? where empid=?");
		ps.setString(1, e.getUsername());
		ps.setString(2, e.getUserid());
		
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else
	     	return false;	
	}
	
	public boolean delete(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from user where empid=?");
		ps.setString(1, e.getUserid());
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
		}
	
	public ResultSet find(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from user where empid=? or empname like ?");
      	ps.setString(1, e.getUserid());
		ps.setString(2,""+e.getUsername()+'%'+"" );	
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
	public ResultSet list(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from user");
		/*
		 * ps.setString(1, e.getUserid()); ps.setString(2,""+e.getUsername()+'%'+"" );
		 */
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	            }
	        }
	
	
}
