package controller;

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
import dao.LibraryDaoNew;
public class findallpaginationcontroller extends Action{
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
// TODO Auto-generated method stub
String spageid=request.getParameter("page");
int pageid=Integer.parseInt(spageid);
 int total=3;
 if(pageid==1){}
else{
 pageid=pageid-1;
 pageid=pageid*total+1;
}
 
 LibraryDaoNew dao = new LibraryDaoNew();
 ResultSet rsv = dao.findAlll(pageid,total);/*pageid,total*/
List list = new ArrayList();
 while (rsv.next()) {
 String bookid = rsv.getString(1);
 String bookname = rsv.getString(2);
 String author = rsv.getString(3);
 String bookcost = rsv.getString(4);
 

 Library ef = new Library();
 ef.setBookid(bookid);
ef.setBookname(bookname);
ef.setBookcost(bookcost);
 ef.setAuthor(author);
 list.add(ef);
}
 System.out.println("controller " + Arrays.asList(list));
 request.setAttribute("reslist", list);
 return mapping.findForward("findAll");
 }
}
