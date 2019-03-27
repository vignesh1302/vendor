package com.cognizant.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.grizzlystore.model.UserDetails;
//import com.cognizant.grizzlystore.util.ConnectionUtil;
import com.cognizant.grizzlystore.util.ConnectionUtil;

public class UserDao 
{
	public static void setDetails(int uId) 
	{
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connObj=null;
		
		try
		{
			connObj=ConnectionUtil.getConnection();
			preparedStatement = connObj.prepareStatement("select username,designation,office from userprofile where userid = ?");
			preparedStatement.setInt(1,uId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) 
			{
				UserDetails.setName(resultSet.getString("username"));
				UserDetails.setDesignation(resultSet.getString("designation"));
				UserDetails.setOffice(resultSet.getString("office"));
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				if(connObj!=null) {
					connObj.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
