package com.cognizant.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ConcurrentModificationException;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.exception.IgrizzlyException;
import com.cognizant.grizzlystore.model.ProductGallery;
import com.cognizant.grizzlystore.util.ConnectionUtil;


public class GalleryDao {
	

		private static GalleryDao galleryDao;
		private GalleryDao() {
			// TODO Auto-generated constructor stub
		}
		public static GalleryDao getGalleryDao()
		{
			if(galleryDao==null)
			{
				galleryDao=new GalleryDao();
			}
			return galleryDao;
		}
	
	public int saveProductImages(ProductGallery productGallery) throws GrizzlyException {

		 Connection connObj=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int empId = 0;
		String query = "insert into product_gallery(pr_id_fk, pr_img_name) values(?,?)" ;
		try {
			connObj=ConnectionUtil.getConnection();
			if (connObj == null) {
				System.out.println("not Got connection");
			} else {
				System.out.println("Got Connected");
			}
			preparedStatement = connObj.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, productGallery.getProductDetails().getProductId());
			preparedStatement.setString(2, productGallery.getimage());
			
			int count = preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				empId = resultSet.getInt(1);
			}
           empId= count;
			if (count >= 1) {
				System.out.println("Product images save");
			} else {

				throw new GrizzlyException("Product images is not saved some internal error");
			}

	

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
		} finally {
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connObj!=null)
					connObj.close();
				}
			catch (SQLException e2) {
				throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
				
			}
			

		}

		return empId;
	}
	
	public int deleteProductImages(int []pid) throws GrizzlyException {

		 Connection connObj=null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
	
		String query = "delete from product_gallery  where pr_id_fk in" ;
		try {
			connObj=ConnectionUtil.getConnection();
			if (connObj == null) {
				System.out.println("not connected");
			} else {
				System.out.println("Connected");
			}
			
			
			StringBuffer sb=new StringBuffer();
			
			for (int i = 0; i < pid.length; i++) {
				sb.append(pid[i]+",");
			}
			sb.deleteCharAt(sb.length()-1);
			
			System.out.println(sb);
			query+="("+sb.toString()+")";
		System.out.println(query);
		preparedStatement = connObj.prepareStatement(query);

			 count = preparedStatement.executeUpdate();

			

			if (count >= 1) {
				System.out.println("Product gallery is deleted"+count);
			} else {

				throw new GrizzlyException("Product gallery is not deleted for issues");
			}

		

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			
			throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
		} finally {
			try {
				if(resultSet!=null)
					resultSet.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connObj!=null)
					connObj.close();
				}
			catch (SQLException e2) {
				throw new GrizzlyException(IgrizzlyException.CLOSING_RESOURCE_ERROR);
				
			}
			


		}

		return count;
	}

}
