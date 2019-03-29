package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="AMP_USERS")
public class Authenticator {
	public Authenticator() {
		super();
	}
	
	@Id
	@Column(name="USERID")
	@GeneratedValue(generator="seq_gen")
	@SequenceGenerator(name="seq_gen",sequenceName="SEQUENCE1")
	int userid;
	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="PASSWORD")
	String password;
	

	public int getuserid() {
		return userid;
	}

	public void setuserid(int userid) {
		this.userid = userid;
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

	
}
