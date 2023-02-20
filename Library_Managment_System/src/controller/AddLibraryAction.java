package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import beans.Employee;
import beans.ExcelCreator;
import beans.Library;
import beans.ReturnBook;
import beans.borrowbook;
import dao.BorrowBookDao;
import dao.EmployeeDao;
import dao.LibraryDao;

public class AddLibraryAction extends DispatchAction{
	public ActionForward savebook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		Library l=(Library) af;
		LibraryDao dao=new LibraryDao();
		
		try {
			int i=dao.save(l);
			ResultSet rsv= dao.booklist();
			ArrayList list = new ArrayList();
			while (rsv.next()) {
				String bookid = rsv.getString(1);
				String bookname = rsv.getString(2);
				String author=rsv.getString(3);
				String bookcost=rsv.getString(4);
				Library ef = new Library();
				ef.setBookid(bookid);
				ef.setBookname(bookname);
				ef.setAuthor(author);
				ef.setBookcost(bookcost);
				list.add(ef);
			}
			req.setAttribute("reslist",list);
			return am.findForward("success");
		}
			catch(Exception ex) {
				req.setAttribute("msg", "Enter Valid BookId / BookId is Already Used");
				return am.findForward("failsave");
			}
		}
	
	
	public ActionForward updatebook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		Library l=(Library) af;
		LibraryDao dao=new LibraryDao();
		try {
			
			boolean i=dao.update(l);
		
			ResultSet rsv= dao.booklist();
			ArrayList list = new ArrayList();
			while (rsv.next()) {
				String bookid = rsv.getString(1);
				String bookname = rsv.getString(2);
				String author=rsv.getString(3);
				String bookcost=rsv.getString(4);
				Library ef = new Library();
				ef.setBookid(bookid);
				ef.setBookname(bookname);
				ef.setAuthor(author);
				ef.setBookcost(bookcost);
				list.add(ef);
			}
			/* System.out.println("updatebook"+list); */
			req.setAttribute("reslist",list);
			if(i==true)
			return am.findForward("booklist");
			}
		catch(Exception ex) {
			req.setAttribute("msg", "Enter Valid UserId / UserId is Already Used");
			return am.findForward("fail");
		}
		return am.findForward("fail");
	} 

	public ActionForward deletebook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Library l=(Library) af;
		LibraryDao dao=new LibraryDao();
		try {
		boolean b=dao.delete(l);
		if(b==true)
		return am.findForward("success");	
	}
		catch(Exception ex) {
			req.setAttribute("msg", "Enter Valid UserId / UserId is Already Used");
			return am.findForward("fail");
		}
		return am.findForward("fail");
	}
	
	
	public ActionForward findbook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	    Library l=(Library) af;
		LibraryDao dao=new LibraryDao();
		ResultSet rsv= dao.find(l);
		ArrayList list = new ArrayList();
		while (rsv.next()) {
			String bookid = rsv.getString(1);
			String bookname = rsv.getString(2);
			String author=rsv.getString(3);
			String bookcost=rsv.getString(4);
			Library ef = new Library();
			ef.setBookid(bookid);
			ef.setBookname(bookname);
			ef.setAuthor(author);
			ef.setBookcost(bookcost);
			list.add(ef);
		}
		req.setAttribute("list",list);
		return am.findForward("find");
		
	}

	
	
	
	/*
	 * public ActionForward bookstatus(ActionMapping am, ActionForm af,
	 * HttpServletRequest req, HttpServletResponse res) throws Exception { Library
	 * b=(Library) af; LibraryDao dao=new LibraryDao(); ResultSet rsv=
	 * dao.bookstat(b); ArrayList list = new ArrayList(); while (rsv.next()) {
	 * String bookid = rsv.getString(1); String bookname = rsv.getString(2); String
	 * userid = rsv.getString(4); String username = rsv.getString(5); String
	 * issuedate = rsv.getString(6); String returndate = rsv.getString(7);
	 * borrowbook bb = new borrowbook (); Employee e=new Employee(); Library l=new
	 * Library(); ReturnBook rb=new ReturnBook(); bb.setBookid(bookid);
	 * l.setBookname(bookname); bb.setUserid(userid); e.setUsername(username);
	 * bb.setIssuedate(issuedate); rb.setReturndate(returndate); list.add(bb);
	 * list.add(l); list.add(e); list.add(rb);
	 * 
	 * 
	 * 
	 * System.out.println("Array List..."+ Arrays.asList(list)); }
	 * req.setAttribute("reslist", list);
	 * 
	 * return am.findForward("list"); }
	 */
	
	
	
	
			/* excel */                                                              		/* excel */
	
//	  static final Logger LOGGER = Logger.getLogger("EmpCrudController.class");
//	  
//	  
//	  public ActionForward importTextFile(ActionMapping am, ActionForm af,
//	  HttpServletRequest req, HttpServletResponse res) throws Exception {
//	  LibraryDao dao11 = new LibraryDao(); 
//	  ResultSet rsv1 = dao11.booklist(); 
//	  List list11 =new ArrayList();
//	  while (rsv1.next()) {
//	  String bookid = rsv1.getString("bookid"); 
//	  System.out.println("test1"+bookid);
//	  Library e1 = new Library();
//	  
//	  e1.setBookid(bookid);
//	  list11.add(bookid);
//	  }
//	  int i=0;
//	  File file = new File( "C:\\Users\\A849641\\Documents\\test.txt");
//	  String fwd = null;
//	  Library e = (Library) af;
//	  
//	  
//	  BufferedReader br = new BufferedReader(new FileReader(file));
//	  
//	  String bookid = getBookid(0); 
//	  String bookname = null;
//	  String author = null;
//	  String bookcost = null;
//	  
//	  String st;
//	while ((st = br.readLine()) != null) { String arr[]=st.split("/");
//	  for(String str:arr) {
//	  
//	  String[] arr1=str.split(",");
//	  
//	  e = new Library();
//		/* bookid=Integer.parseInt(arr1[0]); */
//	  bookid=arr1[0];
//	  bookname=arr1[1];
//	  author=arr1[2];
//	  bookcost=arr1[3]; 
//	  e.setBookname(bookname);
//	  e.setAuthor(author); 
//	  e.setBookcost(bookcost);
//	  e.setBookid(bookid);
//	 
//	  
//	  LOGGER.info("Start EmCrudController"); LibraryDao dao = new LibraryDao();
//	  if(!list11.contains(bookid)){ i = dao.save(e); }
//	  else
//	  {
//	  System.out.println("record exists in db for id and email and id:"+"email "
//	  +"id:"+bookid); }} }
//	  List list = new ArrayList();
//	  
//	  ResultSet rsv=null;
//	  
//	  LibraryDao dao1 = new LibraryDao(); 
//	  rsv = dao1.booklist(); while (rsv.next())
//	  { 
//	  bookid = rsv.getString(1);
//	  bookname = rsv.getString(2); 
//	  author =rsv.getString(3);
//	  bookcost=rsv.getString(4);
//	  }
//	  rsv.getString(3); 
//	  bookcost = rsv.getString(4);
//	  e = new Library();
//	  e.setBookid(bookid); 
//	  e.setBookname(bookname);
//	  e.setAuthor(author);
//	  e.setBookcost(bookcost); 
//	  list.add(e);
//	  
//	  } 
//	  req.setAttribute("reslist", list);
//	  return am.findForward("booklist");
//
//	  
//	  private int getBookid(int i) { // TODO Auto-generated method stub return 0; }
//	  
//		  
		  
		  
	  public ActionForward exportxl(ActionMapping am, ActionForm af,
	  HttpServletRequest req, HttpServletResponse res) throws Exception {
	  
	  LibraryDao dao = new LibraryDao();
	  ResultSet rsv = dao.booklist(); 
	  List list = new ArrayList(); 
	  while (rsv.next()) {
	 String bookid = rsv.getString(1);
	  String bookname = rsv.getString(2); 
	  String author = rsv.getString(3); 
	  String bookcost = rsv.getString(4); 
	  Library e = new Library(); 
	  e.setBookid(bookid);
	  e.setBookname(bookname); 
	  e.setAuthor(author); 
	  e.setBookcost(bookcost);
	  list.add(e);
	  } 
	  
	  ExcelCreator excelCreator = new ExcelCreator(); 
	  HSSFWorkbook workbook = excelCreator.createWorkbook(list); 
	  res.setHeader("Content-Disposition",
	  "attachment; filename=UserDetails.xls"); 
	  ServletOutputStream out =res.getOutputStream(); 
	  workbook.write(out); 
	  out.flush(); 
	  out.close(); 
	  return
	  am.findForward("success");
	  
	  }
	 	

}
