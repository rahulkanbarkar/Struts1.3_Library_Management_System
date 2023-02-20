package beans;
import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class Employee extends ValidatorForm{
 String userid,username;

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}
 
}
