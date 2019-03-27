package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.LoginDetails;

public interface ILoginDao {
    
   int doLogin(LoginDetails loginDetails) throws GrizzlyException;
}
