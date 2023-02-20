package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Employee;
import beans.ExcelCreator;
import beans.Library;
import com.db.connection.DbConnection;

public class LibraryDao extends DbConnection {
	public int save(Library l)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into library values(?,?,?,?)");
		ps.setString(1, l.getBookid());
		ps.setString(2, l.getBookname());
		ps.setString(3, l.getAuthor());
		ps.setString(4,l.getBookcost());
		int i=ps.executeUpdate();
		con.close();
		return i;		
	}
	/* book update */ 
	/* book update */
	public ResultSet getbookupdate(Library l)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Library where bookid=?");
		ps.setString(1, l.getBookid()); 
        ResultSet rs=ps.executeQuery();
		return rs;	
		
	}
	
	public boolean update(Library l)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update Library set bookname=?,author=?,bookcost=? where bookid=?");
		
		ps.setString(1,l.getBookname());
		ps.setString(2,l.getAuthor());
		ps.setString(3,l.getBookcost());
		ps.setString(4,l.getBookid());
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
	}
	
	public boolean getbookbyid(int id)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update Library set bookname=?,author=?,bookcost=? where bookid=?");
	
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
	}
	
	
	/* end book update */                                    /* end book update */
	
	public boolean delete(Library l)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from Library where bookid=? ");
		ps.setString(1, l.getBookid());
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
		}
	
	
	public ResultSet find(Library l)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Library where bookname like ?");
		ps.setString(1,""+l.getBookname()+'%'+"" );	
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	public ResultSet booklist()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from Library ");       
       ResultSet rs= ps.executeQuery();
       return rs;
       }
	
	public ResultSet bookstat(Library l)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select b.bookid, l.bookname,b.userid,u.username,issuedate,returndate from library l ,borrowbook b,user u  where l.bookid = b.bookid and u.userid=b.userid ");       
        ps.setString(1, l.getBookid());
        ps.setString(2,""+l.getBookname()+'%'+"" );	      
        ResultSet rs= ps.executeQuery();
       //System.out.println(rs);
       return rs;
       }

//	public ResultSet bookstatus()throws Exception{
//		Connection con=getConnection();
//        PreparedStatement ps=con.prepareStatement("select * from Library ");       
//       ResultSet rs= ps.executeQuery();
//       return rs;
//       }
//	
	
	
	
	/*public ActionForward exportxl(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		LibraryDao dao = new LibraryDao();
		ResultSet rsv = dao.booklist();
		List list = new ArrayList();
		while (rsv.next()) {
		
			
			String bookid = rsv.getString(1);
			String bookname = rsv.getString(2);
			String author = rsv.getString(3);
			String bookcost = rsv.getString(4);
			Library l = new Library();
			l.setBookid(bookid);
			l.setBookname(bookname);
			l.setAuthor(author);
			l.setBookcost(bookcost);a
			list.add(l);
		}
        */	
		/*
		 * ExcelCreator excelCreator = new ExcelCreator(); HSSFWorkbook workbook =
		 * excelCreator.createWorkbook(list); res.setHeader("Content-Disposition",
		 * "attachment; filename=UserDetails.xls"); ServletOutputStream out =
		 * res.getOutputStream(); workbook.write(out); out.flush(); out.close(); return
		 * am.findForward("success");
		 * }
		 */
		
}
