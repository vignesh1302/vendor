package com.cognizant.grizzlystore.model;

import java.util.*;

public class LoginDetails 
{ 
	   private int userid;
       private String username;
       private String password;
       private String userType;
       private String address;
       private int attempt;
      
       public LoginDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
       
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
              return username;
       }
       public void setUsername(String username) {
              this.username = username;
       }
       public String getPassword() {
              return password;
       }
       public void setPassword(String password) {
              this.password = password;
       }
       public String getUserType() {
              return userType;
       }
       public void setUserType(String userType) {
              this.userType = userType;
       }
       public String getAddress() {
              return address;
       }
       public void setAddress(String address) {
              this.address = address;
       }
       public int getAttempt() {
              return attempt;
       }
       public void setAttempt(int attempt) {
              this.attempt = attempt;
       }
       @Override
       public int hashCode() {
              final int prime = 31;
              int result = 1;
              result = prime * result + ((address == null) ? 0 : address.hashCode());
              result = prime * result + attempt;
              result = prime * result + ((password == null) ? 0 : password.hashCode());
              result = prime * result + ((userType == null) ? 0 : userType.hashCode());
              result = prime * result + ((username == null) ? 0 : username.hashCode());
              return result;
       }
       @Override
       public boolean equals(Object obj) {
              if (this == obj)
                     return true;
              if (obj == null)
                     return false;
              if (getClass() != obj.getClass())
                     return false;
              LoginDetails other = (LoginDetails) obj;
              if (address == null) {
                     if (other.address != null)
                           return false;
              } else if (!address.equals(other.address))
                     return false;
              if (attempt != other.attempt)
                     return false;
              if (password == null) {
                     if (other.password != null)
                           return false;
              } else if (!password.equals(other.password))
                     return false;
              if (userType == null) {
                     if (other.userType != null)
                           return false;
              } else if (!userType.equals(other.userType))
                     return false;
              if (username == null) {
                     if (other.username != null)
                           return false;
              } else if (!username.equals(other.username))
                     return false;
              return true;
       }
       @Override
       public String toString() {
              return "LoginDetails [username=" + username + ", password=" + password + ", userType=" + userType + ", address="
                           + address + ", attempt=" + attempt + "]";
       }
       public LoginDetails() {
              super();
              // TODO Auto-generated constructor stub
       }
       public LoginDetails(String username, String password, String userType, String address, int attempt) {
              super();
              this.username = username;
              this.password = password;
              this.userType = userType;
              this.address = address;
              this.attempt = attempt;
       }

       
}


