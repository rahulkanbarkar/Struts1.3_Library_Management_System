

	
	package controller;

	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.Action;
	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;

import beans.ExcelCreator;
import beans.Library;
import dao.EmployeeDao;
import dao.LibraryDao;

	public class LibraryList extends Action {
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 LibraryDao dao = new LibraryDao();
			ResultSet rsv = dao.booklist();
			List list = new ArrayList();
			while (rsv.next()) {
				System.out.println(rsv.getString(2));
				String bookid = rsv.getString(1);
				String bookname = rsv.getString(2);
				String author = rsv.getString(3);
				String bookcost = rsv.getString(4);
				Library l = new Library();
				l.setBookid(bookid);
				l.setBookname(bookname);
				l.setAuthor(author);
				l.setBookcost(bookcost);
				list.add(l);
			}
			request.setAttribute("reslist", list);
			
			return mapping.findForward("list");
			}
	}
	 
			/*
			 * public ActionForward exportxl(ActionMapping am, ActionForm af,
			 * HttpServletRequest req, HttpServletResponse res) throws Exception {
			 * 
			 * LibraryDao dao = new LibraryDao(); ResultSet rsv = dao.booklist(); List list
			 * = new ArrayList(); while (rsv.next()) {
			 * 
			 * 
			 * String bookid = rsv.getString(1); String bookname = rsv.getString(2); String
			 * author = rsv.getString(3); String bookcost = rsv.getString(4); Library l =
			 * new Library(); l.setBookid(bookid); l.setBookname(bookname);
			 * l.setAuthor(author); l.setBookcost(bookcost);
			 * 
			 * list.add(l);
			 * 
			 * } ExcelCreator excelCreator = new ExcelCreator(); HSSFWorkbook workbook =
			 * excelCreator.createWorkbook(list); res.setHeader("Content-Disposition",
			 * "attachment; filename=UserDetails.xls"); ServletOutputStream out =
			 * res.getOutputStream(); workbook.write(out); out.flush(); out.close(); return
			 * am.findForward("success");
			 * 
			 * }
			 */

//	  public ActionForward findAllByWebService(ActionMapping am, ActionForm af,HttpServletRequest req, HttpServletResponse res) throws Exception {
//	  LibraryDao dao = new LibraryDao();
//	  ResultSet rsv = dao.booklist();
//	  
//	  SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance(); 
//	  SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//	}
	  

	
	
	
	


