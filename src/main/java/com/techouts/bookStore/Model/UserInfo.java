package com.techouts.bookStore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo
{
	private String firstName;
	private String lastName;
	@Id
	private int phoneNumber;
	private String emailId;
	private String gender;
	private String location;
	private String password;
	private String repassword;

	
	public UserInfo() {
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

	

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ", gender=" + gender + ", location=" + location + ", password=" + password
				+ ", repassword=" + repassword + "]";
	}
	

	}



