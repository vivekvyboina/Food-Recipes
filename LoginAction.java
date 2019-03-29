package basics;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import model.Authenticator;
import model.LoginDAO;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware{
    
   
	String username;
	String password;
	private Map<String, Object> sessionMap;

	@Override
	public void setSession(java.util.Map<String,Object> sessionMap) {
		
		this.sessionMap = sessionMap;
	}
	
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String authenticate(){
    	LoginDAO dao=new LoginDAO();
    	Authenticator auth=dao.authenticate(username, password);
    	
         
    	if(auth != null) 
    	{
    		
    		//get the user after successful login, then add user to the map
    		//sessionMap.put("designation", designation);
    		//sessionMap.put("username", designation);
    		
	    	return SUCCESS
    	}
    	
    		return NONE;
    	
    }
	
	
 
    public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
    
    
	@Override
    public void validate(){
    	if(username.equals(" ")){
    		addFieldError("username", "enter username");
    	}
    	if(password.equals(" ")){
    		addFieldError("password", "Enter password");
    	}
    }
	
	/*  public String login()
	    {
	        sessionMap.put(username, );
	        return SUCCESS;
	    }

	    public String logout()
	    {
	        sessionMap.remove(username);
	        return SUCCESS;
	    }*/
	
	
}