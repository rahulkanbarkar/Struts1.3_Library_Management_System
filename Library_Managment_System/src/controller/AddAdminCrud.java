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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Response;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.Action;
/*import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.mysql.cj.result.Row;

import beans.Admin;
//import beans.ExcelCreator;
//import beans.ExcelCreator;
import dao.AdminDao;
//import javafx.scene.control.Cell;

	
public class AddAdminCrud extends DispatchAction {
//	static final Logger LOGGER = Logger.getLogger("AddAdminCrud.class");
	public ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Admin e = (Admin) af;
		System.out.println(e.getFirstname());
		AdminDao dao = new AdminDao();
		
		String dob = req.getParameter("dob");
		
		System.out.println(dob);
		
		String receiveDate = req.getParameter("dob");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date rdate = sdf.parse(receiveDate);
		Date date = new Date();
		System.out.println(date);
		
		if (date.before(rdate)) {
			System.out.println(date);
			System.out.println(rdate);
			req.setAttribute("doberror", "Failed you have entered a wrong date please enter date format YYYY/MM/DD");
			System.out.println("test 01");
			return am.findForward("failreg");
		}
		try {
			int i=dao.save(e);
			String id=e.getId();
			String firstname=e.getFirstname();
			String lastname=e.getLastname();
			String dobs=e.getDob();
			String age=e.getAge();
			String city=e.getCity();
			ArrayList list=new ArrayList();
			list.add(id);
			list.add(firstname);
			list.add(lastname);list.add(dobs);list.add(age);list.add(city);
			req.setAttribute("list", list);
			//System.out.print("List "+list);
			return am.findForward("reg");
			}
			catch(Exception ex) {
				System.out.println("hello mam");
				req.setAttribute("msg", "Enter Valid UserId as number / UserId is Already Used");
				System.out.println("hello mam");
				System.out.println("test 01");
				return am.findForward("failreg");
		}
	}
}


	
	
	
	
