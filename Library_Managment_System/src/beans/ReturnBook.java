package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;


public class ReturnBook extends ValidatorForm {
	Integer bookid;
	String returndate;
	
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
		      HttpServletRequest request) {
		
		    ActionErrors errors = new ActionErrors();
		    
		    if (bookid.equals(0)) {
		      errors.add("bookid", new ActionMessage("bookid.not.entered"));
		    }
		    if (returndate == null || returndate.length() <9) {
		      errors.add("returndate", new ActionMessage("returndate.not.entered"));
		    }

		    return errors;
	}
	/*
	 * public void reset(ActionMapping mapping, HttpServletRequest request) {
	 * 
	 * this.id=null; this.password=""; }
	 */	
}
