package com.mindtree.util;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.dto.ProductDto;
import com.mindtree.dto.UserDto;
import com.mindtree.entity.Apparal;
import com.mindtree.entity.Book;
import com.mindtree.entity.Cart;
import com.mindtree.entity.Product;
import com.mindtree.entity.User;

public class ConvertUserDtoToUser {
	
        public static User convertUserDtoToUser(UserDto userDto) {
		
        //user data to be returned
		User user = new User();
		
		//setting user id
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		
		//cart to set in user detail
		Cart cart = new Cart();
		
		//setting cart id
		cart.setCartId(userDto.getCart().getCartId());
		
		
		//products detail to set in cart
		List<Product> products = new ArrayList<Product>();
		
		for(ProductDto productDto: userDto.getCart().getProducts()) {
			
				if(productDto.getProduct_type().equalsIgnoreCase("Book")) {
                   //System.err.println("Book");
				   Book book = new Book();
				   book.setProdId(productDto.getProductId());
				   book.setProdName(productDto.getProductName());
				   book.setPublications(productDto.getPublications());
				   book.setQuantity(productDto.getQuantity());
				   book.setPrice(productDto.getPrice());
				   book.setGenre(productDto.getGenre());
				   book.setAuthor(productDto.getAuthor());
				   book.setCart(cart);
				   
				   //adding book in products
				   products.add(book);
				   
				} else if (productDto.getProduct_type().equalsIgnoreCase("Apparal")) {
					//System.err.println("Apparal");
					Apparal apparal = new Apparal();
					apparal.setProdId(productDto.getProductId());
					apparal.setProdName(productDto.getProductName());
					apparal.setQuantity(productDto.getQuantity());
					apparal.setPrice(productDto.getPrice());
					apparal.setType(productDto.getApparal_type());
					apparal.setBrand(productDto.getBrand());
					apparal.setDesign(productDto.getDesign());
					apparal.setCart(cart);
					
					//adding Apparal to products
					products.add(apparal);
				}
			
		}
		cart.setProducts(products);
		cart.setUser(user);
		user.setCart(cart);
		
		//System.err.println(user);
		return user;
}
}
