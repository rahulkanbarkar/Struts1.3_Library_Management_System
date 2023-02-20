package beans;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorActionForm;
import org.apache.struts.validator.ValidatorForm;

public class Library extends ValidatorForm {
	String bookid;
	String  bookname, author, bookcost;

	

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookcost() {
		return bookcost;
	}

	public void setBookcost(String bookcost) {
		this.bookcost = bookcost;
	}
	
	  @Override public String toString() { return "Library [bookid=" + bookid +
	  ", bookname=" + bookname + ", author=" + author + ", bookcost=" + bookcost +
	  "]"; }
	  
	  private FormFile excelFile;
	  
	  public FormFile getExcelFile() { return excelFile; }
	  
	  public void setExcelFile(FormFile excelFile) { this.excelFile = excelFile; 
	  }
	  
	  
		/*
		 * @Override public ActionErrors validate(ActionMapping mapping,
		 * HttpServletRequest request) { ActionErrors errors = new ActionErrors();
		 * 
		 * if(bookid==0) { errors.add("bookid",new
		 * ActionMessage("bookid.not.entered"));}
		 * 
		 * // if (bookname== null) { errors.add("bookname", new //
		 * ActionMessage("bookname.not.entered")); // } // // if (author==null) {
		 * errors.add("author", new // ActionMessage("author.not.entered")); } // // if
		 * (bookcost== null) { errors.add("bookcost", new //
		 * ActionMessage("bookcost.not.entered")); } // return errors; } //
		 */
	    
}
