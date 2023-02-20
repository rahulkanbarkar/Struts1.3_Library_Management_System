package dao;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;    
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connection.DbConnection;

import beans.Employee;
import beans.Library;
import beans.ReturnBook;
import beans.borrowbook;

public class BorrowBookDao extends DbConnection {
	public int save(borrowbook b)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into borrowbook(bookid,userid,issuedate) values(?,?,?)");
		
		ps.setString(1, b.getBookid());
		ps.setString(2, b.getUserid());
		ps.setString(3,b.getIssuedate());
		System.out.println("IssueDate DAO "+b.getIssuedate());
		int i=ps.executeUpdate();
		System.out.println(i);
		con.close();
		return i;		
	}
	
	
	public boolean update(borrowbook b)throws Exception{
		Connection con=getConnection();  	
//		Date date= new Date(0);
//		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		PreparedStatement ps=con.prepareStatement("update borrowbook set returndate=? where bookid=?");
		ps.setString(1,b.getReturndate());
		ps.setString(2, b.getBookid());
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
	}
	
	
//	    public int save(ReturnBook b)throws Exception{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("insert into returnbook values(?,?)");
//		ps.setInt(1, b.getBorrowid());
//		ps.setString(2, b.getReturndate());
//		int i=ps.executeUpdate();
//		System.out.println(i);
//		con.close();
//		return i;		
//	}
    
	
	public ResultSet bookstatus(Library b)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select b.bookid, l.bookname,b.borrowid,b.userid,u.username,issuedate,returndate from library l ,borrowbook b,user u  where l.bookid = b.bookid and u.userid=b.userid where bookname like ?");       
        ps.setString(1,""+b.getBookname()+'%'+"" );	      
        ResultSet rs= ps.executeQuery();
       System.out.println(rs);
       return rs;
       }
	public ResultSet list(borrowbook b)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from borrowbook");
//		ps.setInt(1, b.getBookid());
		ResultSet rs=ps.executeQuery();
		return rs;
	}

	
}
