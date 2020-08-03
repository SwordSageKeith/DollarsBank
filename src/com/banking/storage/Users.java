package com.banking.storage;

public class Users {
	private String name;
	private String password;
	private int ID;
	private String Country;
	private String phone;
	private float savings;
	
	public Users(int ID) {
		this.ID = ID;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getSavings() {
		return savings;
	}
	public void setSavings(float savings) {
		this.savings = savings;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	

	
}
