package com.cognizant.grizzlystore.service;

import java.util.List;

import com.cognizant.grizzlystore.dao.ProductDao;
import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.ProductDetails;

public class ProductService implements IProductDao {
     ProductDao dao=ProductDao.getProductDao();

     @Override
     public int saveProductDetails(ProductDetails productDetails) throws GrizzlyException{
           // TODO Auto-generated method stub
           return dao.saveProductDetails(productDetails);
     }

     @Override
     public List<ProductDetails> getAllProductDetails(String filter)throws GrizzlyException {
           // TODO Auto-generated method stub
           return dao.getProductDetails(filter);
     }

     @Override
     public ProductDetails getProductById(int pid) throws GrizzlyException{
           // TODO Auto-generated method stub
           return dao.getProductDetailsById(pid);
     }

     @Override
     public int updateProduct(int[] pid, String status) throws GrizzlyException{
           // TODO Auto-generated method stub
           return dao.updateProductDetails(pid, status);
     }

     @Override
     public int deleteProductDetails(int[] pid) throws GrizzlyException{
           // TODO Auto-generated method stub
           return dao.deleteProductDetails(pid);
     }

	@Override
	public List<ProductDetails> getAllProductDetails() throws GrizzlyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeProduct(int[] pid) throws GrizzlyException {
		// TODO Auto-generated method stub
		return 0;
	}

	


}

