package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.dao.LoginDao;
import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.LoginDetails;

public class LoginService implements ILoginDao {
      LoginDao dao=LoginDao.getLoginDao();
	@Override
	public int doLogin(LoginDetails loginDetails) throws GrizzlyException {
		// TODO Auto-generated method stub
		return dao.doLogin(loginDetails);
	}
	
	@Override
	public String toString() {
		return "LoginService [dao=" + dao + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
