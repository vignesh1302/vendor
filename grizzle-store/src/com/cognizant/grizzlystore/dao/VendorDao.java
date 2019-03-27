package com.cognizant.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.exception.IgrizzlyException;
import com.cognizant.grizzlystore.model.ProductBrands;
import com.cognizant.grizzlystore.model.ProductCategory;
import com.cognizant.grizzlystore.model.ProductDetails;
import com.cognizant.grizzlystore.model.VendorDetails;
import com.cognizant.grizzlystore.service.ProductService;
import com.cognizant.grizzlystore.util.ConnectionUtil;

public class VendorDao {
    
	private static VendorDao vendorDao;
	private VendorDao() {
		
	}
	public static VendorDao getVendorDao()
	{
		if(vendorDao==null)
		{
			vendorDao=new VendorDao();
		}
		return vendorDao;
	}
	
		public List<ProductDetails> getVendortDetails(String filter) throws GrizzlyException
		{
			List<ProductDetails> list=new ArrayList<>();
			Connection connObj=null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String query="select pr.*,br.*,cr.*, pg.*,v.* from product pr join product_category cr join product_brand br join product_gallery pg join vendor v on pr.pr_br_fk=br.br_id and cr.ct_id=pr.pr_ct_fk and pg.pr_id_fk=pr.pr_id and pr.pr_id=v.vr_id where pr_availability='available';" + 
					"";
			try
			{   
				connObj=ConnectionUtil.getConnection();
				if(connObj==null)
				{
				System.out.println("not Got connection");
				}
			else {
				System.out.println("Got Connected");
			}
			if(filter==null || filter.isEmpty() || filter=="") {
			
			}else {
				
				query+=" and pr.pr_id in "+"("+filter+")";
				System.out.println(query);
			}	
				
				
		 preparedStatement = connObj.prepareStatement(query);
		 
		 
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{	
				 int productId=resultSet.getInt("pr_id");
	             String productName =resultSet.getString("pr_name");
	 String productDescription =resultSet.getString("pr_description");
	  double productPrice=resultSet.getDouble("pr_price");
	 double productRating=resultSet.getDouble("pr_rating");

	 String brandName=resultSet.getString("br_name");
	             int brandId=resultSet.getInt("br_id");
	             int categoryId=resultSet.getInt("ct_id");
	             

	             String categoryName=resultSet.getString("ct_name");
	             ProductCategory productCategory=new ProductCategory(categoryId, categoryName);
	               ProductBrands productBrands=new ProductBrands(brandId, brandName);
	                                                 
	             String listImages =resultSet.getString("pr_img_name");
	             
	                                                
	            
	               String availability=resultSet.getString("pr_availability");
	               int quantity=resultSet.getInt("quantity");
	               VendorDetails vendorDetails=new VendorDetails(1, productId, quantity);
	               ProductDetails details=new ProductDetails(productId, productName, productDescription, productPrice, productRating, availability, productBrands, productCategory,listImages,vendorDetails);
	                
	            list.add(details);
	            System.out.println("Details="+details);
			}
			}
			catch(ClassNotFoundException classNotFoundException)
			{
				classNotFoundException.printStackTrace();
				
				throw new GrizzlyException(IgrizzlyException.DRIVER_MISSING_ERROR);
			}
			catch(SQLException sqlException)
			{
				sqlException.printStackTrace();
				
				throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
				}
			     finally {
					try {
					if(resultSet!=null)
						resultSet.close();
					if(preparedStatement!=null)
						preparedStatement.close();
					if(connObj!=null)
						connObj.close();
					}catch(SQLException exception) {
					exception.printStackTrace();
					throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
					
				}
		}
			return list;
		}
			public int updateQuantity(int productId,int quantity) throws GrizzlyException
			{
				int count=0;
				Connection connObj=null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				String query="update vendor set quantity=? where  PR_ID_FK =?";
				try
				{   
					connObj=ConnectionUtil.getConnection();
					if(connObj==null)
					{
					System.out.println("not Got connection");
					}
				else {
					System.out.println("Got Connected");
				}
				if(quantity==0 || quantity<=0) {
				
				}else {
					
					
					System.out.println(query);
				}	
					
				System.out.println(query);		
			 preparedStatement = connObj.prepareStatement(query);
			 preparedStatement.setInt(1, quantity);
			 preparedStatement.setInt(2, productId);
			 
			 
			 
			count= preparedStatement.executeUpdate();
			
				
				}
				catch(ClassNotFoundException classNotFoundException)
				{
					classNotFoundException.printStackTrace();
					
					throw new GrizzlyException(IgrizzlyException.DRIVER_MISSING_ERROR);
				}
				catch(SQLException sqlException)
				{
					sqlException.printStackTrace();
					
					throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
					}
				     finally {
						try {
						if(resultSet!=null)
							resultSet.close();
						if(preparedStatement!=null)
							preparedStatement.close();
						if(connObj!=null)
							connObj.close();
						}catch(SQLException exception) {
						exception.printStackTrace();
						throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
						
					}
			}
				return count;
			}
	}



