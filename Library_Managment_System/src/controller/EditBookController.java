package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Library;
import dao.LibraryDao;

public class EditBookController extends Action{
@Override
public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req,
		HttpServletResponse res) throws Exception {
	System.out.println("test 1");
    Library l=(Library) af;
	LibraryDao dao=new LibraryDao();
	ResultSet rsv= dao.getbookupdate(l);
	ArrayList list = new ArrayList();
	while (rsv.next()) {
		String bookid = rsv.getString(1);
		String bookname = rsv.getString(2);
//		String name=rsv.getString(2);
		/*
		 * if(name==" ") { System.out.print("hi "+name); req.setAttribute("nameerroer",
		 * "enter valid book name"); }
		 */
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
	return am.findForward("updateform");
	
}
}
