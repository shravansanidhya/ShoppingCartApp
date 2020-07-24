package com.mindtree.dto;

import java.util.List;



public class CartDto {

	private int cartId;
	
	private List<ProductDto> products;
	
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDto(int cartId, List<ProductDto> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", products=" + products + "]";
	}
	
	
	
	
}
