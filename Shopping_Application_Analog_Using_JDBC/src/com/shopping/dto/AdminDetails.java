package com.shopping.dto;

import java.io.Serializable;

public class AdminDetails implements Serializable
{
	private int adminID;
	private String adminEmailID;
	private String adminPassword;
	private String adminRole;
	
	public AdminDetails() {}

	public AdminDetails(int adminID, String adminEmailID, String adminPassword, String adminRole) 
	{
		this.adminID = adminID;
		this.adminEmailID = adminEmailID;
		this.adminPassword = adminPassword;
		this.adminRole = adminRole;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminEmailID() {
		return adminEmailID;
	}

	public void setAdminEmailID(String adminEmailID) {
		this.adminEmailID = adminEmailID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	
	public void display()
	{
		System.out.println("Admin ID: "+getAdminID());
		System.out.println("Admin EmailID: "+getAdminEmailID());
		System.out.println("Admin Password: "+getAdminPassword());
		System.out.println("Admin Role: "+getAdminRole());
	}
	
	@Override
	public String toString()
	{
		return " Admin ID: "+getAdminID()+"\n Admin EmailID: "+getAdminEmailID()
		      +" \n Admin Password: "+getAdminPassword()+" \n Admin Role: "+getAdminRole();
	}
}
