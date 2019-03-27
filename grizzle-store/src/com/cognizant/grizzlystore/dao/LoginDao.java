package com.cognizant.grizzlystore.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognizant.grizzlystore.exception.GrizzlyException;
import com.cognizant.grizzlystore.exception.IgrizzlyException;
import com.cognizant.grizzlystore.model.LoginDetails;
import com.cognizant.grizzlystore.model.UserDetails;
import com.cognizant.grizzlystore.util.ConnectionUtil;

public class LoginDao {

	
	private static LoginDao loginDao;
	private LoginDao() {
		// TODO Auto-generated constructor stub
	}
	public static LoginDao getLoginDao()
	{
		if(loginDao==null)
		{
			loginDao=new LoginDao();
		}
		return loginDao;
	}
	
	
	 int count=0;
		
		public int doLogin(LoginDetails logindetails) throws GrizzlyException
		{
			
			String username="k";
			String password="k";
			int cou=0;
			int  userid=0;
			String address;
			Connection connObj=null;
			String user=logindetails.getUsername();
			String pass=logindetails.getPassword();
			System.out.println("DAO"+user+""+pass);
			try
			{   
				connObj=ConnectionUtil.getConnection();
				if(connObj==null)
				{
					System.out.println("not Got connection");
				}
			    else if(user!=null && pass!=null)
			    {
			 
			    	System.out.println("Got Connected");
			       	Statement stmt=connObj.createStatement();
			    	ResultSet rs=null;
	                
	     			String sql = "SELECT username,password,attempt,user_id,address FROM login where username='"+user+"' and password='"+pass+"'";
		    	    rs = stmt.executeQuery(sql);
			        if(rs.next())
			         {
			        	username=rs.getString(1);
			        	password=rs.getString(2);
			            cou=rs.getInt(3);
			            userid=rs.getInt(4);
			            address=rs.getString(5);
			            System.out.println("suc"+username+" "+password+" "+cou);
			            logindetails.setAddress(address);
			            logindetails.setUserid(userid);
			            if(cou <= 3)
			            {
			            	UserDetails.setUId(userid);
			            	UserDao.setDetails(UserDetails.getUId());
			            	int a=0;
			            	String c="Update login set attempt='"+a+"' where username='"+username+"'";
			            	stmt.executeUpdate(c);
			            	return 0;
			            }
			            count=cou;
			         }
			        else
			        {
			        	String errorsql = "SELECT username,attempt FROM login where username='"+user+"' and password!='"+pass+"'";
			        	rs=stmt.executeQuery(errorsql);
			        	if(rs.next())
			        	{
			        		username=rs.getString(1);
			        		cou=rs.getInt(2);
			        		System.out.println("err"+username+" "+cou);
			        		cou=cou+1;
			        		count=cou;
			        		String upt="update login set attempt='"+cou+"' where username='"+username+"'";
			        		stmt.executeUpdate(upt);
			        		System.out.println(username+" "+cou);
			        	}
			        }

					if(rs!=null)
						rs.close();
					if(stmt!=null)
						stmt.close();
				
					}
			    else
			    {
			    	
			    }
				
			}
					catch(ClassNotFoundException classNotFoundException)
					{
						//classNotFoundException.printStackTrace();
						throw new GrizzlyException(IgrizzlyException.DRIVER_MISSING_ERROR);
					}
					catch(SQLException sqlException)
					{
						//classNotFoundException.printStackTrace();
						sqlException.printStackTrace();
						throw new GrizzlyException(IgrizzlyException.SOME_SQL_ERROR);
					}
					catch(Exception e)
					{
						throw new GrizzlyException(IgrizzlyException.CONTACT_TO_ADMIN_ERROR);
						}
			if(connObj!=null)
				try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return count;
			
					
		}
	}
