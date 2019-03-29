package basics;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import model.AssetDB;
import model.Authenticator;
import model.Request;
import model.RequestDB;

@SuppressWarnings("serial")
public class RequestAction extends ActionSupport implements SessionAware {

	Request req=new Request();
	
	private long receipeid;
	private int userid;
	private String receipeName
	private String ingredients;
	private String procedure;
	
	public long getReceipeid() {
		return receipeid;
	}

	public void setReceipeid(long receipeid) {
		this.receipeid = receipeid;
	}

	public int getuserid() {
		return userid;
	}

	public void setuserid(int userid) {
		this.userid = userid;
	}
	
	public String getReceipeName() {
		return receipeName;
	}

	
	public void setReceipeName(String receipeName) {
		this.receipeName = receipeName;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}


	public String getProcedure() {
		return procedure;
	}

	

	public void Procedure(int procedure) {
		this.procedure = procedure;
	}

	

	public List<Request> getList() {
		return list;
	}

	public void setList(List<Request> list) {
		this.list = list;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	private List<Request> list; 
	
	
	Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> sessionmap) {
		session=sessionmap;		
	}
	
	
	
	public String raiseRequest(){
		Authenticator auth1=(Authenticator)session.get("auth");
		RequestDB db=new RequestDB();
		boolean request=db.raiseRequest(auth1,receipeName,ingredients,procedure);
		if(request){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	public String delete(){
		RequestDB db= new RequestDB();
		boolean delete=db.delete(receipeid);
		if(delete){
			return SUCCESS;	
		}else{
			return ERROR;
		}
		
}
