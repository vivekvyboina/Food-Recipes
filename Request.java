package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="REQUEST_TABLE")
public class Request {
	public Request() {
		super();
	}
	
	@Id
	@Column(name="RECIEPE_ID")
	@GeneratedValue(generator="seq_gen")
	@SequenceGenerator(name="seq_gen",sequenceName="SEQUENCE2")
	long reciepeid;
	
	@Column(name="USERID")
	int userid;
	
	@Column(name="RECEIPENAME")
	String recipeName;
	
	@Column(name="INGREDIENTS")
	String ingredients;
	
	@Column(name="PROCEDURE")
	String procedure;
	

	public long getReceipeid() {
		return reciepeid;
	}

	public void setReceipeid(int reciepeid) {
		this.reciepeid = reciepeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getReceipeName() {
		return recipeName;
	}

	public void setReceipeName(String recipeName) {
		this.recipeName = recipeName;
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

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

}
