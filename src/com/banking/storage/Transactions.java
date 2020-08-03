package com.banking.storage;

public class Transactions {
	private int userID;
	private int ID;
	private int targetID;
	private float value;
	public enum Type {deposit, withdraw, transfer, create};
	private Type type;
	
	public Transactions(Type type, int id) {
		this.type = type;
		this.ID = id;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTargetID() {
		return targetID;
	}
	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
