

	
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

import beans.Admin;
import beans.Library;
import dao.AdminDao;
import dao.LibraryDao;

	public class RegList extends Action {
	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 AdminDao dao = new AdminDao();
			ResultSet rsv = dao.reglist();
			List list = new ArrayList();
			
			
			while (rsv.next()) {
				System.out.println(rsv.getString(2));
				String id = rsv.getString(1);
				String firstname = rsv.getString(2);
				String lastname = rsv.getString(3);
				String dob = rsv.getString(4);
				String age = rsv.getString(4);
				String city = rsv.getString(4);
				String password= rsv.getString(4);
                
				Admin l = new Admin();
			    l.setId(id);
				l.setFirstname(firstname);
				l.setFirstname(lastname);
				l.setDob(dob);
				l.setAge(age);
				l.setCity(city);
				l.setPassword(password);

				list.add(l);
				System.out.println(list);
			}
			request.setAttribute("reslist", list);
			
			System.out.println(list);
			return mapping.findForward("reglist");
			}
	 
	 
	}

	
	
	
	


