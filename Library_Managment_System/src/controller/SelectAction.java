package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Employee;
import beans.Library;
import dao.EmployeeDao;
import dao.LibraryDaoNew;

public class SelectAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("boookid Selected"+"hello test");
		Library e=(Library) form;
		
		LibraryDaoNew dao = new LibraryDaoNew();
		String Bookid = request.getParameter("Bookid");
		System.out.println("Bookid selected i"+Bookid);
		
		ResultSet rsv=dao.find(Integer.parseInt(Bookid));
		List<Library> list=new ArrayList<Library>();
		while(rsv.next()) {
			/* System.out.println(rsv.getString(2)); */
			int id=rsv.getInt(1);
			String bookname=rsv.getString(2);
			String author=rsv.getString(3);
			String bookcost=rsv.getString(4);
			Library ef=new Library();
			ef.setBookid(Bookid);
			ef.setBookname(bookname);
			ef.setAuthor(author);
			ef.setBookcost(bookcost);
			list.add(ef);
			System.out.println("test 1");
		}
		request.setAttribute("updatelist",list);
		System.out.println("TESTT3");
		return mapping.findForward("updatedelete");
	}}