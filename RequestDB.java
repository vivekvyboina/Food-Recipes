package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RequestDB {
	SessionFactory request;
	
	@SuppressWarnings("deprecation")
	public RequestDB(){
		request=new Configuration().configure()
				.addAnnotatedClass(Request.class)
				.buildSessionFactory();
	}
	public boolean raiseRequest(Authenticator auth,String reciepeName,String ingredients,String procedure) {
		
		Session ssn=request.openSession();
		Transaction tx=ssn.beginTransaction();
		//ssn.createQuery("from Request");
		Request req=new Request();
		req.setuserid(auth.getuserid());
		req.setReceipeName(reciepeName);
		req.setIngredients(ingredients);
		req.setProcedure(procedure);
		ssn.save(req);
		tx.commit();
		ssn.close();
		return true;
	}
	
	
  public List viewMyRequest(Authenticator auth){
   
	int id=auth.employeeid;
	Session ssn=request.openSession();
	Transaction tx=ssn.beginTransaction();
	Query qry= ssn.createQuery("From Request");
	List<Request> requestList = qry.list();
	List<Request> list = new ArrayList();
	for(Request req:requestList)
		if(req.employeeid==id)
		{
			list.add(req);
		}
	
	return list;
  
}

public boolean delete(int requestid) {
		Session ssn = admin.openSession();
		Transaction tr=ssn.beginTransaction();
		Request auth = (Request) ssn.get(Request.class, requestid);
		ssn.delete(auth);
		tr.commit();
		ssn.close();
		return true;
	}

}
