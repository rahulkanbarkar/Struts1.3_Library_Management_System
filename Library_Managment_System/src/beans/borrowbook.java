package beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class borrowbook extends ValidatorForm{
	
	private String bookid,userid;
	private String issuedate;
	private String returndate;

	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getUserid() {
		return userid;
	}
	
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	
}
