package com.ust.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.LoginBean;

public class LoginImpDao implements LoginIntDao {
	//declaring Jdbctemplate to connect with database
	JdbcTemplate template;
	
	//defining setters for template
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//define function for check the authentication
	/* (non-Javadoc)
	 * @see com.ust.dao.LoginIntDao#verifyUserLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public LoginBean verifyUserLogin(String uname, String pass) {
		
		LoginBean lb=new LoginBean();
		//sql query for select logId
		String sql = "select logId from fe_loginTable where uName = ? and pass=?";
		
		//return true value when give username and password is correct
		try{
			return template.queryForObject(sql,new Object[] { uname, pass },
				new BeanPropertyRowMapper<LoginBean>(LoginBean.class));	
		 
		}catch(Exception e){
			return lb;
		}

	}
	
}
