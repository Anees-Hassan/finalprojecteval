package com.ust.model;


//Creating bean class for login
public class LoginBean {

	//declaring property fro storing logindetails
	private int logId; 
	private String uname;
	private String pass;
	
	//constructor with all details as parameter
	public LoginBean(int logId, String uname, String pass) {
		super();
		this.logId = logId;
		this.uname = uname;
		this.pass = pass;
	}

	//constructor with all details except id as parameter
	public LoginBean(String uname, String pass) {
		super();
		this.uname = uname;
		this.pass = pass;
	}

	//define default constructor
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	//defining all getters and setter for all variables
	public int getLogId() {
		return logId;
	}

	public String getUname() {
		return uname;
	}

	public String getPass() {
		return pass;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	//overriding to string function
	@Override
	public String toString() {
		return "LoginBean [logId=" + logId + ", uname=" + uname + ", pass="
				+ pass + "]";
	}
	
	
	
}
