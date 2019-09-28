package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.LoginIntDao;
import com.ust.model.LoginBean;

@RestController
public class LoginController {

	//Autowired Login service
	@Autowired
	LoginIntDao lDao;
	
	//Calling rest api of login controller
	@RequestMapping(value = "/api/verifyLogin/{uname}/{pass}", method = RequestMethod.GET)
	//Assign passed variables to strings
	public LoginBean verifyLogin(@PathVariable("uname") String uname,
			@PathVariable("pass") String pass) {

		//return logId 
		return lDao.verifyUserLogin(uname, pass);
		
	}
}
