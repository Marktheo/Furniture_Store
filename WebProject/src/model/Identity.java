package model;

import java.sql.Date;

import dao.ExceptionDAO;
import dao.IdentityDAO;

public class Identity {
	private String State = null;
	private String fName = null;
	private String lName = null;
	private String bDate = null;
	private String sex = null;
	private String cpf = null;
	
	public Identity() {
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String date) {
		this.bDate = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}
