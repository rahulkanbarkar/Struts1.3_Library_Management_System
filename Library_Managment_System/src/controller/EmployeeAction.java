package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import beans.Employee;
import beans.Library;
import dao.EmployeeDao;
import dao.LibraryDao;
import com.db.connection.DbConnection;

public class EmployeeAction extends DispatchAction{
	
	public ActionForward saveemp(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		//System.out.println(id);
		try {
		int i=dao.save(e);
		return am.findForward("success");
		}
		catch(Exception ex) {
			req.setAttribute("msg", "Enter Valid EmployeeId / Employee id is Already Used");
			return am.findForward("empadd");
		}
	}

	public ActionForward empupdate(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		boolean b=dao.update( e);
		if(b==true)
		return am.findForward("success");
		else 
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
	
	
	public ActionForward empdelete(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		try {
		boolean b=dao.delete(e);
		if(b==true)
		return am.findForward("success");
		}
		catch(Exception ex) {
			req.setAttribute("msg", "Enter Valid UserId / UserId is Already Used");
			return am.findForward("fail");
		}
			return am.findForward("fail");
	}
	
	public ActionForward empfind(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	    Employee e=(Employee) af;
	    EmployeeDao dao=new EmployeeDao();
		ResultSet rsv= dao.find(e);
		ArrayList list = new ArrayList();
		while (rsv.next()) {
			String userid = rsv.getString(1);
			String username = rsv.getString(2);
			Employee ef = new Employee();
			ef.setUserid(userid);
			ef.setUsername(username);
			list.add(ef);
		}
		req.setAttribute("list",list);
		System.out.println(list);
		return am.findForward("findemp");	
	}
	
	public ActionForward emplist(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	    Employee e=(Employee) af;
	    EmployeeDao dao=new EmployeeDao();
		ResultSet rsv= dao.list(e);
		ArrayList list = new ArrayList();
		while (rsv.next()) {
			String userid = rsv.getString(1);
			String username = rsv.getString(2);
			Employee ef = new Employee();
			ef.setUserid(userid);
			ef.setUsername(username);
			list.add(ef);
		}
		req.setAttribute("list",list);
		System.out.println(list);
		return am.findForward("listemp");	
	}
	}  