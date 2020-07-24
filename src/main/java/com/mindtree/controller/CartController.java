package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dao.CartDao;
import com.mindtree.dao.ProductDao;
import com.mindtree.dao.UserDao;
import com.mindtree.dto.ProductDto;
import com.mindtree.dto.UserDto;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.CartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody UserDto userDto) throws ServiceException {

		String msg ="";
		try{
		  msg = this.cartService.addProduct(userDto);
		
		} catch (ServiceException e) {
			msg = "Unable to Add";
		}
		return msg;
			
	}
	
	@DeleteMapping("/delete/{pid}/{cid}")
	public String DeleteProductsFromCart(@PathVariable int pid,@PathVariable int cid) throws ServiceException {
		String msg ="";
		try {
			msg = this.cartService.DeleteProductsFromCart(pid, cid);
		} catch (ServiceException e) {
			msg = "Unable to Delete";
		}
		return msg;
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers() {
		
		return this.cartService.getAllUsers();
		
	}
	
	@GetMapping("/addToCart/{pid}/{cid}/{uid}")
	public String addToCart(@PathVariable int pid, @PathVariable int cid, @PathVariable int uid) throws ServiceException {
		String msg = "";
		try {
			msg = this.cartService.addProductToCart(pid,cid,uid);
		} catch(ServiceException e) {
			msg = "Unable to add to Cart";
		}
		
		return msg;
		
	}
	
	@GetMapping("getProductsByCartId/{cartId}")
	public List<ProductDto> getProductsByCartId(@PathVariable int cartId) {
		return this.cartService.getProductsByCartId(cartId);
	}
	
	
	@GetMapping("findProductFromCart/{pid}/{cid}")
	public ProductDto findProductFromCart(@PathVariable int pid,@PathVariable int cid) throws ServiceException {
		
		return this.cartService.findProductFromCart(pid, cid);
	}
	
}
