package com.mindtree.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dao.CartDao;
import com.mindtree.dao.ProductDao;
import com.mindtree.dao.ProductStockDao;
import com.mindtree.dao.UserDao;
import com.mindtree.dto.ProductDto;
import com.mindtree.dto.UserDto;
import com.mindtree.entity.Cart;
import com.mindtree.entity.Product;
import com.mindtree.entity.User;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.CartService;
import com.mindtree.util.ConvertUserDtoToUser;
import com.mindtree.util.ProductStockToProduct;
import com.mindtree.util.ProductToProductDto;
import com.mindtree.util.UserToUserDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductStockDao productStockDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public String addProduct(UserDto userDto) throws ServiceException {
		String msg = "";
		try{
		User user = ConvertUserDtoToUser.convertUserDtoToUser(userDto);
		this.userDao.save(user);
		msg = "Added Successfully";
		}
		catch(Exception e) {
			throw new ServiceException("Something Went Wrong");
		}
		return msg;
	}
	
	@Override
	public List<UserDto> getAllUsers() {

		
		List<User> users = this.userDao.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();

		for(User user: users) {
			UserDto userDto = new UserDto();
			userDto = UserToUserDto.convertUserToUserDto(user);
			userDtos.add(userDto);
		}
		return userDtos;
		
	}

	@Override
	public String addProductToCart(int pid, int cid, int uid) throws ServiceException {
		String msg = "";
		
		try{
		if(this.productDao.findProductFromCart(pid, cid)!=null) {
			 
			 ProductDto productDto = ProductToProductDto.ConvertProductToProductDto(this.productDao.findProductFromCart(pid,cid));
			 float price = productDto.getPrice()/productDto.getQuantity();
			 productDto.setQuantity(productDto.getQuantity()+1);
			 productDto.setPrice(price*productDto.getQuantity());
			 this.productDao.updateProductInCart(productDto.getQuantity(), productDto.getPrice(), pid, cid);
			 msg = "Updated Successfully";
		} else {
		User user = new User();
		user.setUserId(uid);
		user.setUserName("Rahul");
		Cart cart = new Cart();
		cart.setCartId(cid);
		Product product = new Product();
		product = ProductStockToProduct.convertProductStockToProduct(this.productStockDao.findProductById(pid));
		product.setCart(cart);
		this.productDao.save(product);
		msg = "Added to Cart Successfully";
	}
	} catch(Exception e) {
		throw new ServiceException("Something Went Wrong");
	}
		return msg;
	}

	@Override
	public  List<ProductDto> getProductsByCartId(int cartId) {
		
		 List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		if(this.cartDao.findById(cartId).isPresent()) {

			  productDtos = ProductToProductDto.ConvertProductsToProductDtos(this.productDao.findProductsByCartId(cartId));	
		}
		return productDtos;
	}

	@Override
	public String DeleteProductsFromCart(int pid, int cid) throws ServiceException {

		String msg = "";
		try{
		if(this.productDao.findProductFromCart(pid, cid)!=null) {
			 ProductDto productDto = ProductToProductDto.ConvertProductToProductDto(this.productDao.findProductFromCart(pid,cid));
			 if(productDto.getQuantity()>1) {
				 float price = productDto.getPrice()/productDto.getQuantity();
				 productDto.setQuantity(productDto.getQuantity()-1);
				 productDto.setPrice(price*productDto.getQuantity());
				 this.productDao.updateProductInCart(productDto.getQuantity(), productDto.getPrice(), pid, cid);				 
				 msg = "Deleted one product from cart";
			 } else {
					this.productDao.DeleteProductsFromCart(pid, cid);
					msg = "Deleted Product from Cart Successfully";
			 }
		}
		}catch (Exception e) {
			throw new ServiceException("Something Went Wrong");
		}
		return msg;
	}

	@Override
	public ProductDto findProductFromCart(int pid, int cid) throws ServiceException {
		 ProductDto productDto= new ProductDto();
		 try{
		 productDto = ProductToProductDto.ConvertProductToProductDto(this.productDao.findProductFromCart(pid,cid));
		 } catch (Exception e) {
			 throw new ServiceException("Unable to find");
		 }
		 return productDto;
	}
}
