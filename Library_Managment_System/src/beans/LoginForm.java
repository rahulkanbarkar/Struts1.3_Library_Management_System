package beans;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm{
	 private String id;
//	 String s=String.valueOf(id);
	private String password;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
		      HttpServletRequest request) {
		
		    ActionErrors errors = new ActionErrors();
		    if (id== null|| id.length()==0) {
//		    if (id.equals(0)) {
		      errors.add("id", new ActionMessage("id.not.entered"));
		    }
		    
		    if (password == null || password.length() == 0) {
		      errors.add("password", new ActionMessage("password.not.entered"));
		    }
		    
		    return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id="";
        this.password="";
	}
}