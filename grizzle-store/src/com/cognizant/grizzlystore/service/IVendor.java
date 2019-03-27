package com.cognizant.grizzlystore.service;

import com.cognizant.grizzlystore.exception.GrizzlyException;

public interface IVendor {
                 public int updateQuantity(int productId,int quantity) throws GrizzlyException;
}
