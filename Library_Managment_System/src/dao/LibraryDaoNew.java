 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connection.DbConnection;

import beans.Employee;
import beans.Library;

public class LibraryDaoNew  extends DbConnection{
	public int save(Library l) throws Exception {
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into library values(?,?,?,?)");
		ps.setString(1, l.getBookid());
		ps.setString(2, l.getBookname());
		ps.setString(3, l.getAuthor());
		ps.setString(4,l.getBookcost());
		System.out.println("i am hear"+l.getBookid());
		int i=ps.executeUpdate();
		System.out.println("i am hear"+i);
		con.close();
		return i;		
	}

	
	public boolean update(Library l)throws Exception {
		Connection con=getConnection();
		System.out.println("TESTT8");
		System.out.println("update bookid  "+l.getBookid());
        PreparedStatement ps=con.prepareStatement("update Library set bookname=?,author=?,bookcost=? where bookid=?");
		ps.setString(1, l.getBookname());
		ps.setString(2, l.getAuthor());
		ps.setString(3,l.getBookcost());
	    ps.setString(4, l.getBookid());
	    System.out.println("update bookid  "+l.getBookid());
	    System.out.println("update booname  "+l.getBookname());
	   
        int i=ps.executeUpdate();
        System.out.println("TESTT9"+i);
        con.close();	
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public boolean delete(Library l)throws Exception{
		Connection con=getConnection();
		System.out.println("TESTT7");
        PreparedStatement ps=con.prepareStatement("delete from Library where bookid=?");
        ps.setString(1,l.getBookid());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public ResultSet find(int Bookid)throws Exception{
		Connection con=getConnection();
		System.out.println("TESTT4");
        PreparedStatement ps=con.prepareStatement("select * from Library where bookid=?");
        ps.setInt(1,Bookid);
        ResultSet rs= ps.executeQuery();
        System.out.print("DAO");
        return rs;
	}
	public ResultSet findempcrud(Library l)throws Exception{
		Connection con=getConnection();
		System.out.println("TESTT5");
        PreparedStatement ps=con.prepareStatement("select * from Library where bookid=?");
        ps.setString(1, l.getBookid()); 
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
	}
	public ResultSet findAll()throws Exception{
		Connection con=getConnection();
		System.out.println("TESTT6");
        PreparedStatement ps=con.prepareStatement("select * from Library");	
       ResultSet rs= ps.executeQuery();
       return  rs;	
	}
	
	public ResultSet findAlll(int start , int total)throws Exception{
		Connection con=getConnection();
		System.out.println("TESTT6");
        PreparedStatement ps=con.prepareStatement("select * from Library limit \"+(start-1)+\",\"+total");	
       ResultSet rs= ps.executeQuery();
       return  rs;
}
	}