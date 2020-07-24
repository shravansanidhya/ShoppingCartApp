package com.mindtree.service;

import java.util.List;



import com.mindtree.dto.ProductDto;
import com.mindtree.dto.UserDto;
import com.mindtree.exception.ServiceException;

public interface CartService {
	
	public String addProduct(UserDto userDto) throws ServiceException;
				
	public List<UserDto> getAllUsers();
			
	public String addProductToCart(int pid, int cid, int uid) throws ServiceException;
	
	public List<ProductDto> getProductsByCartId(int cartId);
	
	public String DeleteProductsFromCart(int pid,int cid) throws ServiceException;
	
	public ProductDto findProductFromCart(int pid,int cid) throws ServiceException;
		
}
