package com.cognizant.grizzlystore.model;



public class UserDetails {
private static int uId;
private static String name;
private static String designation;
private static String office;
public static String getName() {
	return name;
}

public static void setName(String name) {
	UserDetails.name = name;
}

public static String getDesignation() {
	return designation;
}

public static void setDesignation(String designation) {
	UserDetails.designation = designation;
}

public static String getOffice() {
	return office;
}

public static void setOffice(String office) {
	UserDetails.office = office;
}

public static int getUId() {
	return uId;
}

public static void setUId(int uid) {
	UserDetails.uId = uid;
}

}