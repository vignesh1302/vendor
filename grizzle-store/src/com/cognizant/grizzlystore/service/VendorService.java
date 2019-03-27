package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.dao.VendorDao;
import com.cognizant.grizzlystore.exception.GrizzlyException;


public class VendorService implements IVendor {
          VendorDao dao= VendorDao.getVendorDao();
	
	@Override
	public int updateQuantity(int productId,int quantity) throws GrizzlyException {
		// TODO Auto-generated method stub
		return quantity;
	}
                 
}
