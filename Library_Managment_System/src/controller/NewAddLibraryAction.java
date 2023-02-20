package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.mysql.cj.result.Row;

import beans.Employee;
import beans.ExcelCreator;
import beans.Library;
import dao.EmployeeDao;
import dao.LibraryDaoNew;
/*import javafx.scene.control.Cell;*/

public class NewAddLibraryAction extends DispatchAction {
	static final Logger LOGGER = Logger.getLogger("EmpCrudController.class");
	public ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ResultSet rsv =null;
		Library e = (Library) af;
		LOGGER.info("Start EmCrudController");
		LibraryDaoNew dao = new LibraryDaoNew();
		try {
		int i = dao.save(e);
		ResultSet rsv1 = dao.findAll();
		List list = new ArrayList();
		while (rsv1.next()) {
			String bookid = rsv1.getString(1);
			String bookname = rsv1.getString(2);
			String author=rsv1.getString(3);
			String bookcost=rsv1.getString(4);
			Library ef = new Library();
			ef.setBookid(bookid);
			ef.setBookname(bookname);
			ef.setAuthor(author);
			ef.setBookcost(bookcost);
			list.add(ef);
			ef = null;
		}
		req.setAttribute("reslist", list);
		System.out.println("test"+list);
		if (i != 0)
		return am.findForward("findAll");
		System.out.println("i am hear"+i);
		
			return am.findForward("success");
		}
		catch(Exception ex) {

			req.setAttribute("msg", "Enter Valid BookId / BookId is Already Used");
			return am.findForward("fail");
		}
		
	}
	
//	public ActionForward importTextFile(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
//			throws Exception {
//		EmployeeDao dao11 = new EmployeeDao();
//		ResultSet rsv1 = dao11.findAll();
//		List list11 =new ArrayList();
//	while (rsv1.next()) {
//		
//		String email = rsv1.getString("email");
//		System.out.println(email);
//		
//		 Employee e1 = new Employee();
//		
//		e1.setEmail(email);
//		list11.add(email);
//
//	}
//		
//		int i=0;
//		  File file = new File(
//		            "C:\\Users\\A849641\\Documents\\test.txt");
//		  String fwd = null;
//		  Employee e = (Employee) af;
//		        // Note:  Double backquote is to avoid compiler
//		        // interpret words
//		        // like \test as \t (ie. as a escape sequence)
//		 
//		        // Creating an object of BufferedReader class
//		        BufferedReader br
//		            = new BufferedReader(new FileReader(file));
//		 
//		        // Declaring a string variable
//		        int id = getInt(0);
//		        String st;
//		        String name = null;
//		    	String email = null;
//		    	String gender = null;
//		    	String username = null;
//		    	String password = null;
//		        // Condition holds true till
//		        // there is character in a string
//		        while ((st = br.readLine()) != null) {
//		         String arr[]=st.split("/");
//		        for(String str:arr) {
//		        	
//		        	String[] arr1=str.split(",");
//		        	
//		          e = new Employee();
//		        	 id=Integer.parseInt(arr1[0]);
//		        	 name=arr1[1];
//		        	 email=arr1[2];
//		        	 gender=arr1[3];
//		        	 username=arr1[4];
//		        	 password=arr1[5];
//		        	 e.setName(name);
//		        	 e.setEmail(email);
//		        	 e.setGender(gender);
//		        	 e.setUsername(username);
//		        	 e.setPassword(password);
//		        	 e.setId(id);
//		      
//		
//		LOGGER.info("Start EmCrudController");
//		EmployeeDao dao = new EmployeeDao();
//		if(!list11.contains(email)){
//		 i = dao.save(e);
//		        }else{
//		        	System.out.println("record exists in db for id and email and id:"+email +"id:"+id);
//		        }}
//		        }
//		List list = new ArrayList();
//
//		 ResultSet rsv=null;
//		 
//			EmployeeDao dao1 = new EmployeeDao();
//			 rsv = dao1.findAll();
//		while (rsv.next()) {
//			 id = rsv.getInt(1);
//			 name = rsv.getString(2);
//			 email = rsv.getString(3);
//			 gender = rsv.getString(4);
//			 username = rsv.getString(5);
//			 password = rsv.getString(6);
//			 e = new Employee();
//			e.setId(id);
//			e.setName(name);
//			e.setEmail(email);
//			e.setGender(gender);
//			e.setUsername(username);
//			e.setPassword(password);
//			list.add(e);
//		}
//		req.setAttribute("reslist", list);  
//		        return am.findForward("findAll");
//		        }
//
//	private int getInt(int i) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	public ActionForward update(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Library e = (Library) af;
		LOGGER.info("Start Update");
		System.out.println("JSPTESTT2"+"  "+e.getBookid());
		LibraryDaoNew dao = new LibraryDaoNew();
		boolean b = dao.update(e);
		
		/* System.out.println("JSPTESTT2"+"  "+e.getBookid()); */
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
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
			ef = null;
		}
		req.setAttribute("reslist", list);
		System.out.println("test"+list);
		if (b == true)
			return am.findForward("findAll");
		else
			return am.findForward("fail");
	}

	public ActionForward delete(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Library e = (Library) af;
		LOGGER.info("Start Delete");
		LibraryDaoNew dao = new LibraryDaoNew();
		System.out.println("JSPTESTT3");

		boolean b = dao.delete(e);
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
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
			ef = null;
		}
		req.setAttribute("reslist", list);
		System.out.println("TEST delete fff");
		if (b == true) {
			System.out.println("TEST final pass");
			return am.findForward("findAll");
		}
		else {
			System.out.println("TEST final fail");
			return am.findForward("fail");}
	}

	public ActionForward find(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Library e = (Library) af;
		LOGGER.info("Start Find");
		System.out.println(" you are finding me "+e.getBookid());
		LibraryDaoNew dao = new LibraryDaoNew();
		ResultSet rsv = dao.findempcrud(e);
		List list = new ArrayList();
		while (rsv.next()) {
			System.out.println(rsv.getString(2));
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
		req.setAttribute("reslist", list);
		return am.findForward("find");
	}

	
	public ActionForward findAll(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		LibraryDaoNew dao = new LibraryDaoNew();
		ResultSet rsv = dao.findAll();
		System.out.println("JSPTESTT1");
		List list = new ArrayList();
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
		req.setAttribute("reslist", list);
		
		return am.findForward("findAll");
	}

	public ActionForward exportxl(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		LibraryDaoNew dao = new LibraryDaoNew();
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
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
		ExcelCreator excelCreator = new ExcelCreator();
		HSSFWorkbook workbook = excelCreator.createWorkbook(list);
		res.setHeader("Content-Disposition", "attachment; filename=UserDetails.xls");
		ServletOutputStream out = res.getOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
		return am.findForward("success");

	}
	
	
	/*
	 * public ActionForward findAllByWebService(ActionMapping am, ActionForm af,
	 * HttpServletRequest req, HttpServletResponse res) throws Exception {
	 * EmployeeDao dao = new EmployeeDao(); ResultSet rsv = dao.findAll();
	 * 
	 * SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
	 * .newInstance(); SOAPConnection soapConnection = soapConnectionFactory
	 * .createConnection();
	 * 
	 * // Send SOAP Message to SOAP Server SOAPMessage soapResponse =
	 * soapConnection.call( createSOAPRequest(soapAction, webServicePronosDto),
	 * soapEndpointUrl);
	 * 
	 * List list = new ArrayList(); while (rsv.next()) { int id = rsv.getInt(1);
	 * String name = rsv.getString(2); String email = rsv.getString(3); String
	 * gender = rsv.getString(4); String username = rsv.getString(5); String
	 * password = rsv.getString(6); Employee e = new Employee(); e.setId(id);
	 * e.setName(name); e.setEmail(email); e.setGender(gender);
	 * e.setUsername(username); e.setPassword(password); list.add(e);
	 * 
	 * } req.setAttribute("reslist", list); return am.findForward("findAll"); }
	 */
	
	    
	    
	    
	}
	

