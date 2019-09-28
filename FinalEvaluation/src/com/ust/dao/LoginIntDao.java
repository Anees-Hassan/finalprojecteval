package com.ust.dao;

import com.ust.model.LoginBean;

//interface for login
public interface LoginIntDao {

	//define function for check the authentication
	public abstract LoginBean verifyUserLogin(String uname, String pass);

}