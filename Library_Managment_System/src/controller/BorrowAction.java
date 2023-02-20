package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import beans.Employee;
import beans.Library;
import beans.ReturnBook;
import beans.borrowbook;
import dao.BorrowBookDao;
import dao.EmployeeDao;
import dao.LibraryDao;


public class BorrowAction extends DispatchAction{
	public ActionForward borrowbook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		borrowbook b=(borrowbook) af;
		BorrowBookDao dao=new BorrowBookDao();
		String issuedate = req.getParameter("issuedate");
		/* System.out.println("IssueDate Action "+b.getIssuedate()); */
		try {
			int i=dao.save(b);
			
			return am.findForward("success");
			}
			catch(Exception ex) {
				req.setAttribute("msg", "Enter Valid BookId and Valid Employee Id");
				return am.findForward("fail");
			}
			
		/*
			 * int i=dao.save(b); if(i!=0) return am.findForward("success"); else return
			 * am.findForward("fail");
			 */
	}
	
	public ActionForward returnbook(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		borrowbook l=(borrowbook) af;
		BorrowBookDao dao=new BorrowBookDao();
		/* System.out.println("hvfdgv"+ l.getBookid()); */
		String bookid=l.getBookid();
		/*
		 * if(bookid==null) { req.setAttribute("doberror",
		 * "Failed you have entered a wrong date please enter date format YYYY/MM/DD");
		 * }
		 */
		boolean b=dao.update( l);
		if(b==true)
		return am.findForward("success");
		else 
			return am.findForward("fail");
	} 
	
	public ActionForward datelist(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	    borrowbook l=(borrowbook) af;
	    BorrowBookDao dao=new BorrowBookDao();
		ResultSet rsv= dao.list(l);
		ArrayList list = new ArrayList();
		while (rsv.next()) {
			String bookid= rsv.getString(1);
			String userid = rsv.getString(2);
			String issuedate = rsv.getString(3);
			String returndate = rsv.getString(4);
			borrowbook ef = new borrowbook();
			ef.setBookid(bookid);
			ef.setUserid(userid);
			ef.setIssuedate(issuedate);
			ef.setReturndate(returndate);
			list.add(ef);
		}
		req.setAttribute("list",list);
		return am.findForward("success");	
	}
}