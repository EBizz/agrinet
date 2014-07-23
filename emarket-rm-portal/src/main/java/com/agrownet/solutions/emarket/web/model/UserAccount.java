package com.agrownet.solutions.emarket.web.model;

import java.io.Serializable;

public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = -3126339472491270618L;
	private String userName;
	private String firstName;
	private String lastName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
