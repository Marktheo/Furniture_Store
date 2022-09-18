package model;

import java.sql.Date;
import java.sql.SQLException;

import dao.ExceptionDAO;
import dao.IdentityDAO;
import dao.RegisterDAO;

public class Register {
	private String email = null;
	private String keyword = null;
	
	public Register() {
	}
	
	public Register(String email){
		this.setEmail(email);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
