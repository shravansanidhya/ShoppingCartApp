package com.mindtree.util;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.dto.CartDto;
import com.mindtree.dto.ProductDto;
import com.mindtree.dto.UserDto;
import com.mindtree.entity.Apparal;
import com.mindtree.entity.Book;
import com.mindtree.entity.Product;
import com.mindtree.entity.User;

public class UserToUserDto {

	public static UserDto convertUserToUserDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		
		CartDto cartDto = new CartDto();
		cartDto.setCartId(user.getCart().getCartId());
		
		List<ProductDto> products =new ArrayList<ProductDto>();
		
		for(Product product: user.getCart().getProducts()) {
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProdId());
			productDto.setProductName(product.getProdName());
			productDto.setPrice(product.getPrice());
			productDto.setQuantity(product.getQuantity());
			
			if(product instanceof Book) {
			productDto.setProduct_type("Book");
			productDto.setAuthor(((Book) product).getAuthor());
			productDto.setGenre(((Book) product).getGenre());
			productDto.setPublications(((Book) product).getPublications());
			productDto.setQuantity(product.getQuantity());
			products.add(productDto);
	
			} else if(product instanceof Apparal) {
				productDto.setProduct_type("Apparal");
			    productDto.setBrand(((Apparal) product).getBrand());
				productDto.setDesign(((Apparal) product).getDesign());
				productDto.setApparal_type(((Apparal) product).getType());
				products.add(productDto);
				
			}
			cartDto.setProducts(products);
		}
		userDto.setCart(cartDto);
		return userDto;
		
	}
	
}
