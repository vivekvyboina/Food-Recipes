package basics;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.Authenticator;
import model.LoginDAO;
//import model.RequestDAO;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport implements SessionAware{
	
	Authenticator auth = new Authenticator();
	Map<String, Object> session;
	
	public Authenticator getAuth() {
		return auth;
	}

	public void setAuth(Authenticator auth) {
		this.auth = auth;
	}
	
	
	private int userid;

	private String password;
		
	private List<Authenticator> userList;
	
	public int getuserid() {
		return userid;
	}

	public void setuserid(int userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authenticator> getUserList() {
		return userList;
	}

	public void setUserList(List<Authenticator> userList) {
		this.userList = userList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String addUsers() throws ParseException {
		LoginDAO dao=new LoginDAO();
		System.out.println("hie");
		boolean add = dao.addUser(username,password);
		if(add){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	   
}


