package model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoginDAO {
	SessionFactory admin;
	SessionFactory admin1;
	
	@SuppressWarnings("deprecation")
	public LoginDAO(){
		admin=new Configuration().configure()
				.addAnnotatedClass(Authenticator.class)
				.buildSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public Authenticator authenticate(String username,String password){
		
		Session ssn=admin.openSession();
		Transaction tx=ssn.beginTransaction();
		Query qry=ssn.createQuery("from Authenticator");
		List<Authenticator> list=qry.list();
		tx.commit();
		ssn.close();	
		Iterator<Authenticator> it = list.iterator();
		while(it.hasNext()){
			Authenticator auth = it.next();		
			if(auth.getusername().equals(username) &&	auth.getPassword().equals(password)&& auth.active.equals("active"))
			{
				
				return auth;				
			}
			
		}
		return null;	
	}

	public boolean addUser(String username,String password) throws ParseException {
		Session ssn=admin.openSession();
		Transaction tx=ssn.beginTransaction();
		Authenticator auth=new Authenticator();
		//System.out.println("hie");
		/*SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date=sdf.parse(joining);
		java.sql.Date joining1=new java.sql.Date(date.getTime());*/
		auth.setusername(username);
		
        auth.setPassword(password);
		
		Serializable save = ssn.save(auth);
		//Long id = (Long)ssn.save(auth);
		tx.commit();
		ssn.close();
		if(save==null)
			return false;
		else			
			return true;
	}
	
}
