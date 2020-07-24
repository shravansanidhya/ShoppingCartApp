package com.mindtree.dto;



public class UserDto {

	private int userId;
	
	private String userName;
	
	private CartDto cart;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int userId, String userName, CartDto cart) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cart = cart;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public CartDto getCart() {
		return cart;
	}
	public void setCart(CartDto cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", cart=" + cart + "]";
	}
	
	
	
	
}
