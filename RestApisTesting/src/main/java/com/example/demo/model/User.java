package com.example.demo.model;

public class User {
	
	private int userId;
	private String userName;
	private Address userAddress;
	
	
	
	public User(int userId, String userName, Address userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAddress=" + userAddress + "]";
	}

}
