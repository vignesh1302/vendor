
package com.cognizant.grizzlystore.service;

import java.util.List;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.model.ProductDetails;

public interface IProductDao {
	
	public int saveProductDetails(ProductDetails productDetails) throws GrizzlyException;
	public List<ProductDetails> getAllProductDetails() throws GrizzlyException;
	public ProductDetails getProductById(int pid) throws GrizzlyException;
	public int updateProduct(int[] pid,String status) throws GrizzlyException;
	public int removeProduct(int[] pid) throws GrizzlyException;
	List<ProductDetails> getAllProductDetails(String filter) throws GrizzlyException;
	int deleteProductDetails(int[] pid) throws GrizzlyException;
	
}
