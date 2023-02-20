//
//
//	
//	package controller;
//
//	import java.sql.ResultSet;
//	import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//	import javax.servlet.http.HttpServletRequest;
//	import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.StyledEditorKit.BoldAction;
//
//import org.apache.struts.action.Action;
//	import org.apache.struts.action.ActionForm;
//	import org.apache.struts.action.ActionForward;
//	import org.apache.struts.action.ActionMapping;
//
//import beans.Library;
//import beans.Admin;
//import beans.Employee;
//import beans.ReturnBook;
//import beans.borrowbook;
//import dao.BorrowBookDao;
//import dao.LibraryDao;
//  
//    
//    public class BookStatusAction extends Action {
//	 public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		 BorrowBookDao dao = new BorrowBookDao();
//			ResultSet rsv = dao.bookstatus();
//			List list = new ArrayList();
//			while (rsv.next()) {
//				System.out.println(rsv.getString(2));
//				Integer bookid = rsv.getInt(1);
//				String bookname = rsv.getString(2);
//				Integer borrowid = rsv.getInt(3);
//				Integer userid = rsv.getInt(4);
//        		String username = rsv.getString(5);
//        		String issuedate = rsv.getString(6);
//        		String returndate = rsv.getString(7);
//				borrowbook bb = new borrowbook ();
//				Employee e=new Employee();
//				Library l=new Library();
//          		ReturnBook rb=new ReturnBook();				
//				bb.setBookid(bookid);
//				l.setBookname(bookname);
//				bb.setBorrowid(borrowid);
//				bb.setUserid(userid);
//				e.setUsername(username);
//				bb.setIssuedate(issuedate);
//				rb.setReturndate(returndate);
//				list.add(bb);
//				list.add(l);
//				list.add(e);
//				list.add(rb);
//				System.out.println("Array List..."+ Arrays.asList(list));
//			}
//			request.setAttribute("reslist", list);
//			
//			return mapping.findForward("list");
//			}
//	 
//	 
//	}
//
//	
//	
//	
//	
//
//
