package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.validator.ValidatorActionForm;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class Admin extends ValidatorForm {
	private String id;
	private String firstname, lastname, dob, age, city, password;
    
	public String getId() {
	

		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
//  @Override 
//	  public ActionErrors validate(ActionMapping mapping,
//	  HttpServletRequest request) { ActionErrors errors = new ActionErrors();
//
//	  if (id== 0) { errors.add("id", new
//		  ActionMessage("firstname.not.entered")); }
//	return errors;
//  }
	
//	  if (firstname.length() < 3) { errors.add("firstname", new
//	  ActionMessage("firstname.not.entered")); }
//	  
//	  if (lastname == null || lastname.length() ==0) { errors.add("lastname", new
//	  ActionMessage("lastname.not.entered")); }
//	  
//	  if (dob == null || dob.length() <10 ) { errors.add("dob", new
//	  ActionMessage("dob.not.entered")); }
//	  
//	  if (age == null || age.length() == 0) { errors.add("age", new
//	  ActionMessage("age.not.entered")); }
//	  
//	  
//	  if (city == null || city.length() == 0) { errors.add("city", new
//	  ActionMessage("city.not.entered")); } 
//	 
//	  if (password == null ||password.length() <4) { errors.add("password", new
//	  ActionMessage("password.not.entered")); } return errors; }
//	 
	}